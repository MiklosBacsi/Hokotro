#!/bin/bash
set -uo pipefail  # Strict mode (but without -e so we can continue on errors)

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

    # Run the Java program (input from tests/, output captured to out/)
    cat "tests/${test_num}.txt" | java -cp target/classes Prototype > "out/${test_num}.txt" 2>&1

    local test_failed=0

    # Process all assertions for this test
    while [[ $# -gt 0 ]]; do
        local pattern="$1"
        local expected=$2
        shift 2

        local actual
        actual=$(grep -c "$pattern" "out/${test_num}.txt" || echo 0)

        if [ "$actual" -ne "$expected" ]; then
            echo "   ❌  Expected '$pattern' to appear $expected time(s), but got $actual"
            test_failed=1
        else
            echo "   ✅  '$pattern' count is correct ($actual)"
        fi
    done

    if [ $test_failed -eq 1 ]; then
        echo "   Test ${test_num} FAILED"
        echo "   → Output preview:"
        echo "   --------------------------------------------------"
        cat "out/${test_num}.txt" | head -n 30
        echo "   --------------------------------------------------"
        FAILED=$((FAILED + 1))
    else
        echo "   Test ${test_num} PASSED"
    fi

    echo ""
}

# ======================  YOUR TESTS GO HERE  ======================

run_test 1 \
    "Buys item" 5 \
    "Hero dies" 2

run_test 2 \
    "Rides" 4 \
    "Cuts" 3

# Add more tests easily:
# run_test 3 \
#     "Makes food" 5 \
#     "Eats" 8

# run_test 4 \
#     "Some other string" 10 \
#     "Another string" 0

# =================================================================

echo "========================================"
echo "Test Summary:"
echo "   Total tests:  $TOTAL"
echo "   Failed:       $FAILED"

if [ $FAILED -gt 0 ]; then
    echo "❌  Some tests failed!"
    exit 1
else
    echo "🎉  All tests passed successfully!"
    exit 0
fi