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

    // --- Test Cases for rob (LeetCode 198) ---

    @Test
    void testRob_Example1() {
        int[] nums = {1, 2, 3, 1};
        int expected = 4;
        assertEquals(expected, DP1.rob(nums));
    }

    @Test
    void testRob_Example2() {
        int[] nums = {2, 7, 9, 3, 1};
        int expected = 12;
        assertEquals(expected, DP1.rob(nums));
    }

    @Test
    void testRob_SingleHouse() {
        int[] nums = {5};
        int expected = 5;
        assertEquals(expected, DP1.rob(nums));
    }

    @Test
    void testRob_TwoHouses() {
        int[] nums = {2, 1};
        int expected = 2;
        assertEquals(expected, DP1.rob(nums));
    }

    @Test
    void testRob_TwoHousesSecondGreater() {
        int[] nums = {1, 2};
        int expected = 2;
        assertEquals(expected, DP1.rob(nums));
    }

    @Test
    void testRob_ThreeHousesOptimalSkip() {
        int[] nums = {2, 1, 1, 2};
        int expected = 4;
        assertEquals(expected, DP1.rob(nums));
    }

    @Test
    void testRob_AllZeros() {
        int[] nums = {0, 0, 0, 0};
        int expected = 0;
        assertEquals(expected, DP1.rob(nums));
    }

    @Test
    void testRob_MixedValues() {
        int[] nums = {2, 1, 4, 5, 3, 1};
        int expected = 9;
        assertEquals(expected, DP1.rob(nums));
    }

    @Test
    void testRob_LongSequence() {
        int[] nums = {6, 6, 4, 8, 4, 3, 3, 10};
        int expected = 27;
        assertEquals(expected, DP1.rob(nums));
    }

    @Test
    void testRob_MaxConstraintLength() {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                nums[i] = 400;
            } else {
                nums[i] = 0;
            }
        }
        int expected = 50 * 400;
        assertEquals(expected, DP1.rob(nums));
    }

    @Test
    void testRob_NullInput() {
        int[] nums = null;
        assertThrows(NullPointerException.class, () -> DP1.rob(nums));
    }

   // --- Test Cases for robCircular (LeetCode 213) ---

    @Test
    void testRobCircular_Example1() {
        int[] nums = {2, 3, 2};
        assertEquals(3, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_Example2() {
        int[] nums = {1, 2, 3, 1};
        assertEquals(4, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_Example3() {
        int[] nums = {1, 2, 3};
        assertEquals(3, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_SingleHouse() {
        int[] nums = {1};
        assertEquals(1, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_TwoHouses() {
        int[] nums = {1, 2};
        assertEquals(2, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_AllZeros() {
        int[] nums = {0, 0, 0, 0};
        assertEquals(0, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_MixedValues() {
        int[] nums = {10, 0, 5, 0, 20};
        assertEquals(25, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_LargeValues() {
        int[] nums = {1000, 1, 1000, 1, 1000};
        assertEquals(2000, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_AllSameValue() {
        int[] nums = {5, 5, 5, 5, 5};
        assertEquals(10, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_AlternatingValues() {
        int[] nums = {1, 10, 1, 10, 1};
        assertEquals(20, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_ManyHousesIncreasing() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(30, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_ManyHousesDecreasing() {
        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertEquals(30, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_LongArrayWithZeros() {
        int[] nums = {1, 0, 0, 0, 10, 0, 0, 0, 5};
        assertEquals(15, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_EdgeCaseThreeHousesRobFirst() {
        int[] nums = {10, 1, 1};
        assertEquals(10, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_EdgeCaseThreeHousesRobMiddle() {
        int[] nums = {1, 10, 1};
        assertEquals(10, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_EdgeCaseFourHouses() {
        int[] nums = {1, 2, 1, 1};
        assertEquals(3, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_AnotherFourHouses() {
        int[] nums = {2, 7, 9, 3};
        assertEquals(11, DP1.robCircular(nums));
    }

    @Test
    void testRobCircular_FourHousesMaximum() {
        int[] nums = {2, 7, 9, 3, 1};
        assertEquals(11, DP1.robCircular(nums));
    }
}