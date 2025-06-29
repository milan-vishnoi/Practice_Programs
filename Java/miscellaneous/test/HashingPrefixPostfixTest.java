package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import miscellaneous.HashingPrefixPostfix;

public class HashingPrefixPostfixTest {

    // --- Test Cases for subarraySum (LeetCode 560) ---

    @Test
    void testSubarraySum_Example1() {
        int[] nums = {1, 1, 1};
        int k = 2;
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_Example2() {
        int[] nums = {1, 2, 3};
        int k = 3;
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_WithNegativeNumbers() {
        int[] nums = {1, -1, 0};
        int k = 0;
        int expected = 3;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_AllPositive() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_AllNegative() {
        int[] nums = {-1, -2, -3, -4, -5};
        int k = -3;
        int expected = 2;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_SingleElementArray_Match() {
        int[] nums = {5};
        int k = 5;
        int expected = 1;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_SingleElementArray_NoMatch() {
        int[] nums = {5};
        int k = 0;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_NoMatch() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 100;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_ZeroKWithZeros() {
        int[] nums = {0, 0, 0, 0, 0};
        int k = 0;
        int expected = 15;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_MixedNumbersComplex() {
        int[] nums = {1, -1, 1, -1, 1};
        int k = 0;
        int expected = 6;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_LongArray() {
        int[] nums = new int[20000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i % 2 == 0) ? 1 : -1;
        }
        int k = 0;
        int expected = 100000000;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_LargeValuesOfK() {
        int[] nums = {1_000, 1_000, 1_000, 1_000, 1_000};
        int k = 3_000;
        int expected = 3;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_MinMaxValues() {
        int[] nums = {1000, -1000, 1000, -1000, 1000, -1000};
        int k = 1000;
        int expected = 6;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_NullArray() {
        int[] nums = null;
        int k = 0;
        assertThrows(NullPointerException.class, () -> HashingPrefixPostfix.subarraySum(nums, k));
    }

    @Test
    void testSubarraySum_EmptyArray() {
        int[] nums = {};
        int k = 0;
        int expected = 0;
        assertEquals(expected, HashingPrefixPostfix.subarraySum(nums, k));
    }

}