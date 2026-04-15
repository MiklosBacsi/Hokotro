#!/bin/bash
set -uo pipefail

echo "=== Building Prototype ==="
mvn clean compile --batch-mode --no-transfer-progress

echo "=== Running integration tests ==="

mkdir -p out

FAILED=0
TOTAL=0

run_test() {
    local test_num=$1
    local test_name=$2
    TOTAL=$((TOTAL + 1))

    echo "→ Running Test ${test_num} (${test_name})..."

    # Check input file
    local input_file="tests/${test_num}_${test_name}.txt"
    if [ ! -f "$input_file" ]; then
        echo "   ❌  Test ${test_num} FAILED: Input file ${input_file} not found!"
        FAILED=$((FAILED + 1))
        echo ""
        return
    fi

    # Check requirement file (same naming format)
    local req_file="test-requirements/${test_num}_${test_name}.txt"
    if [ ! -f "$req_file" ]; then
        echo "   ❌  Test ${test_num} FAILED: Requirement file ${req_file} not found!"
        FAILED=$((FAILED + 1))
        echo ""
        return
    fi

    # Run the Java program
    cat "$input_file" | java -cp target/classes hokotro.Prototype > "out/${test_num}.txt" 2>&1

    local test_failed=0

    echo "   Checking requirements:"

    # Read each line from the requirement file
    while IFS= read -r line || [ -n "$line" ]; do
        # Skip empty lines and comments
        [[ -z "$line" || "$line" =~ ^[[:space:]]*# ]] && continue

        # Parse "pattern":expected
        if [[ "$line" =~ ^[[:space:]]*\"([^\"]+)\"[[:space:]]*:[[:space:]]*([0-9]+)[[:space:]]*$ ]]; then
            local pattern="${BASH_REMATCH[1]}"
            local expected="${BASH_REMATCH[2]}"
        else
            echo "   ❌  Invalid requirement format in ${req_file}: '${line}'"
            echo "       Expected format: \"Pattern\":123"
            test_failed=1
            continue
        fi

        # Count occurrences (exact match)
        local actual
        actual=$(grep -c -F "$pattern" "out/${test_num}.txt" | tr -d '[:space:]')
        actual=${actual:-0}

        if [ "$actual" -ne "$expected" ]; then
            echo "   ❌  Expected \"$pattern\" to appear $expected time(s), but got $actual"
            test_failed=1
        else
            echo "   ✅  \"$pattern\" count is correct ($actual)"
        fi
    done < "$req_file"

    if [ $test_failed -eq 1 ]; then
        echo "   Test ${test_num} FAILED"
        echo "   → Output preview (first 40 lines):"
        echo "   --------------------------------------------------"
        head -n 40 "out/${test_num}.txt"
        echo "   --------------------------------------------------"
        FAILED=$((FAILED + 1))
    else
        echo "   Test ${test_num} PASSED"
    fi

    echo ""
}

# ======================  AUTOMATIC TEST DISCOVERY  ======================

echo "Discovering tests in 'tests/' folder..."

# Find files like: 1_name.txt, 2_otherName.txt, 10_bigTest_something.txt
for test_file in tests/*.txt; do
    if [ -f "$test_file" ]; then
        filename=$(basename "$test_file")

        # Extract number and name: 1_name.txt → num=1, name=name
        if [[ "$filename" =~ ^([0-9]+)_(.+)\.txt$ ]]; then
            test_num="${BASH_REMATCH[1]}"
            test_name="${BASH_REMATCH[2]}"

            if [ "$test_num" -gt 0 ]; then
                run_test "$test_num" "$test_name"
            fi
        fi
    fi
done

# =======================================================================

echo "========================================"
echo "Test Summary:"
echo "   Total tests run:   $TOTAL"
echo "   Tests failed:      $FAILED"

if [ $FAILED -gt 0 ]; then
    echo "❌  Some tests failed!"
    exit 1
else
    echo "🎉  All tests passed successfully!"
    exit 0
fi