package advancedproblems.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import advancedproblems.DP1;

public class DP1Test {

    // --- Test Cases for fib (LeetCode 509) ---

    @Test
    void testFib_BaseCaseN0() {
        int n = 0;
        int expected = 0;
        assertEquals(expected, DP1.fib(n));
    }

    @Test
    void testFib_BaseCaseN1() {
        int n = 1;
        int expected = 1;
        assertEquals(expected, DP1.fib(n));
    }

    @Test
    void testFib_N2() {
        int n = 2;
        int expected = 1;
        assertEquals(expected, DP1.fib(n));
    }

    @Test
    void testFib_N3() {
        int n = 3;
        int expected = 2;
        assertEquals(expected, DP1.fib(n));
    }

    @Test
    void testFib_N4() {
        int n = 4;
        int expected = 3;
        assertEquals(expected, DP1.fib(n));
    }

    @Test
    void testFib_N5() {
        int n = 5;
        int expected = 5;
        assertEquals(expected, DP1.fib(n));
    }

    @Test
    void testFib_N10() {
        int n = 10;
        int expected = 55;
        assertEquals(expected, DP1.fib(n));
    }

    @Test
    void testFib_N20() {
        int n = 20;
        int expected = 6765;
        assertEquals(expected, DP1.fib(n));
    }

    @Test
    void testFib_MaxConstraintN30() {
        int n = 30;
        int expected = 832040;
        assertEquals(expected, DP1.fib(n));
    }

    @Test
    void testFib_NegativeN() {
        int n = -1;
        assertThrows(IllegalArgumentException.class, () -> DP1.fib(n), "Should throw IllegalArgumentException for n < 0");
    }

    // --- Test Cases for climbStairs (LeetCode 70) ---

    @Test
    void testClimbStairs_N1() {
        int n = 1;
        int expected = 1;
        assertEquals(expected, DP1.climbStairs(n));
    }

    @Test
    void testClimbStairs_N2() {
        int n = 2;
        int expected = 2;
        assertEquals(expected, DP1.climbStairs(n));
    }

    @Test
    void testClimbStairs_N3() {
        int n = 3;
        int expected = 3;
        assertEquals(expected, DP1.climbStairs(n));
    }

    @Test
    void testClimbStairs_N4() {
        int n = 4;
        int expected = 5;
        assertEquals(expected, DP1.climbStairs(n));
    }

    @Test
    void testClimbStairs_N5() {
        int n = 5;
        int expected = 8;
        assertEquals(expected, DP1.climbStairs(n));
    }

    @Test
    void testClimbStairs_N10() {
        int n = 10;
        int expected = 89;
        assertEquals(expected, DP1.climbStairs(n));
    }

    @Test
    void testClimbStairs_N20() {
        int n = 20;
        int expected = 10946;
        assertEquals(expected, DP1.climbStairs(n));
    }

    @Test
    void testClimbStairs_MaxConstraintN45() {
        int n = 45;
        int expected = 1836311903;
        assertEquals(expected, DP1.climbStairs(n));
    }

    @Test
    void testClimbStairs_ZeroN() {
        int n = 0;
        assertThrows(IllegalArgumentException.class, () -> DP1.climbStairs(n), "Should throw IllegalArgumentException for n <= 0");
    }

    @Test
    void testClimbStairs_NegativeN() {
        int n = -1;
        assertThrows(IllegalArgumentException.class, () -> DP1.climbStairs(n), "Should throw IllegalArgumentException for n <= 0");
    }
}