package miscellaneous.test;

import org.junit.jupiter.api.Test;

import miscellaneous.KadaneMaxSumSubArray;

import static org.junit.jupiter.api.Assertions.*;

class KadaneMaxSumSubArrayTest {

    @Test
    void testStandardCase() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, KadaneMaxSumSubArray.maxSubArray(nums), "Failed on the standard mixed array case.");
    }

    @Test
    void testAllPositiveNumbers() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(15, KadaneMaxSumSubArray.maxSubArray(nums), "Failed when all numbers are positive.");
    }

    @Test
    void testAllNegativeNumbers() {
        int[] nums = {-1, -2, -3, -4, -5};
        assertEquals(-1, KadaneMaxSumSubArray.maxSubArray(nums), "Failed when all numbers are negative.");
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        assertEquals(0, KadaneMaxSumSubArray.maxSubArray(nums), "Failed on an empty array.");
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {5};
        assertEquals(5, KadaneMaxSumSubArray.maxSubArray(nums), "Failed on a single element array.");
    }
    
    @Test
    void testSingleNegativeElementArray() {
        int[] nums = {-5};
        assertEquals(-5, KadaneMaxSumSubArray.maxSubArray(nums), "Failed on a single negative element array.");
    }

    @Test
    void testArrayWithZeroAsMax() {
        int[] nums = {-5, -2, -10, 0, -1};
        assertEquals(0, KadaneMaxSumSubArray.maxSubArray(nums), "Failed on an array with negative numbers and a zero.");
    }
    
    @Test
    void testAnotherMixedCase() {
        int[] nums = {5, 4, -1, 7, 8};
        assertEquals(23, KadaneMaxSumSubArray.maxSubArray(nums), "Failed on another mixed array case.");
    }
}