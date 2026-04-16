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

    local input_file="tests/${test_num}_${test_name}.txt"
    local req_file="test-requirements/${test_num}_${test_name}.txt"

    if [ ! -f "$input_file" ]; then
        echo "   ❌  Test ${test_num} FAILED: Input file ${input_file} not found!"
        FAILED=$((FAILED + 1))
        echo ""
        return
    fi

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

    while IFS= read -r line || [ -n "$line" ]; do
        [[ -z "$line" || "$line" =~ ^[[:space:]]*# ]] && continue

        local pattern
        local expected
        local is_regex=false

        # Exact match: "text":number
        if [[ "$line" =~ ^[[:space:]]*\"([^\"]+)\"[[:space:]]*:[[:space:]]*([0-9]+)[[:space:]]*$ ]]; then
            pattern="${BASH_REMATCH[1]}"
            expected="${BASH_REMATCH[2]}"

        # Regex match: r/regex/:number
        elif [[ "$line" =~ ^[[:space:]]*r/(.+?)/[[:space:]]*:[[:space:]]*([0-9]+)[[:space:]]*$ ]]; then
            pattern="${BASH_REMATCH[1]}"
            expected="${BASH_REMATCH[2]}"
            is_regex=true
        else
            echo "   ❌  Invalid format in ${req_file}: '${line}'"
            echo "       Use: \"exact text\":123   or   r/regex/:123"
            test_failed=1
            continue
        fi

        # Count occurrences
        local actual
        if [ "$is_regex" = true ]; then
            actual=$(grep -c -E "$pattern" "out/${test_num}.txt" | tr -d '[:space:]')
        else
            actual=$(grep -c -F "$pattern" "out/${test_num}.txt" | tr -d '[:space:]')
        fi
        actual=${actual:-0}

        if [ "$actual" -ne "$expected" ]; then
            local type="Exact"
            [ "$is_regex" = true ] && type="Regex"
            echo "   ❌  [$type] Expected \"$pattern\" to appear $expected time(s), but got $actual"
            test_failed=1
        else
            local type="Exact"
            [ "$is_regex" = true ] && type="Regex"
            echo "   ✅  [$type] \"$pattern\" count is correct ($actual)"
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

# ======================  AUTOMATIC TEST DISCOVERY (Numerical Order)  ======================

echo "Discovering tests in 'tests/' folder..."

# Collect all valid test numbers first, then sort them numerically
mapfile -t test_files < <(ls tests/*.txt 2>/dev/null)

tests_to_run=()

for test_file in "${test_files[@]}"; do
    if [ -f "$test_file" ]; then
        filename=$(basename "$test_file")
        if [[ "$filename" =~ ^([0-9]+)_(.+)\.txt$ ]]; then
            test_num="${BASH_REMATCH[1]}"
            test_name="${BASH_REMATCH[2]}"
            if [ "$test_num" -gt 0 ]; then
                tests_to_run+=("$test_num:$test_name")
            fi
        fi
    fi
done

# Sort tests numerically by test number
IFS=$'\n' sorted_tests=($(sort -t: -k1,1n <<<"${tests_to_run[*]}"))
unset IFS

# Run tests in correct numerical order
for entry in "${sorted_tests[@]}"; do
    test_num="${entry%%:*}"
    test_name="${entry#*:}"
    run_test "$test_num" "$test_name"
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