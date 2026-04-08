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
    shift
    TOTAL=$((TOTAL + 1))

    echo "→ Running Test ${test_num}..."

    # Check if input file exists
    if [ ! -f "tests/${test_num}.txt" ]; then
        echo "   ❌  Test ${test_num} FAILED: Input file tests/${test_num}.txt not found!"
        FAILED=$((FAILED + 1))
        echo ""
        return
    fi

    # Run the Java program and capture output
    cat "tests/${test_num}.txt" | java -cp target/classes Prototype > "out/${test_num}.txt" 2>&1

    local test_failed=0

    # Process all pattern/expected pairs
    while [[ $# -gt 0 ]]; do
        local pattern="$1"
        local expected="$2"
        shift 2

        # Clean count: remove any whitespace or newlines
        local actual
        actual=$(grep -c "$pattern" "out/${test_num}.txt" | tr -d '[:space:]')

        # Convert to number safely
        if ! [[ "$actual" =~ ^[0-9]+$ ]]; then
            actual=0
        fi

        if [ "$actual" -ne "$expected" ]; then
            echo "   ❌  Expected '$pattern' to appear $expected time(s), but got $actual"
            test_failed=1
        else
            echo "   ✅  '$pattern' count is correct ($actual)"
        fi
    done

    if [ $test_failed -eq 1 ]; then
        echo "   Test ${test_num} FAILED"
        echo "   → Output preview (first 30 lines):"
        echo "   --------------------------------------------------"
        head -n 30 "out/${test_num}.txt"
        echo "   --------------------------------------------------"
        FAILED=$((FAILED + 1))
    else
        echo "   Test ${test_num} PASSED"
    fi

    echo ""
}

# ======================  YOUR TESTS  ======================

run_test 1 \
    "Buys item" 5 \
    "Hero dies" 2

# Uncomment and adjust when you add more tests:
# run_test 2 \
#     "Rides" 4 \
#     "Cuts" 3

# run_test 3 \
#     "Makes food" 5 \
#     "Eats" 8

# =========================================================

echo "========================================"
echo "Test Summary:"
echo "   Total tests run:  $TOTAL"
echo "   Failed:           $FAILED"

if [ $FAILED -gt 0 ]; then
    echo "❌  Some tests failed!"
    exit 1
else
    echo "🎉  All tests passed successfully!"
    exit 0
fi