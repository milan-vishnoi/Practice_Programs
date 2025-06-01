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

    @Test
void testCircularArrayCase1() {
    int[] nums = {5, -3, 5};
    assertEquals(10, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on circular case with wraparound.");
}

@Test
void testCircularArrayCase2_AllNegative() {
    int[] nums = {-3, -2, -3};
    assertEquals(-2, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on circular case with all negative numbers.");
}

@Test
void testCircularArrayCase3_WrapAroundEdge() {
    int[] nums = {3, -1, 2, -1};
    assertEquals(4, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on circular case with optimal wrap.");
}

@Test
void testCircularArrayCase4_SingleElement() {
    int[] nums = {7};
    assertEquals(7, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on circular case with single element.");
}

@Test
void testCircularArray_AllZeros() {
    int[] nums = {0, 0, 0, 0};
    assertEquals(0, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on all zero values.");
}

@Test
void testCircularArray_AllSamePositive() {
    int[] nums = {3, 3, 3, 3};
    assertEquals(12, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on all same positive values.");
}

@Test
void testCircularArray_AllSameNegative() {
    int[] nums = {-2, -2, -2, -2};
    assertEquals(-2, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on all same negative values.");
}

@Test
void testCircularArray_WrapMiddleDrop() {
    int[] nums = {8, -1, -3, 8};
    assertEquals(16, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on circular wrap with a middle dip.");
}

@Test
void testCircularArray_LargeNegativeGap() {
    int[] nums = {10, -20, 10, 10, 10};
    assertEquals(40, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed when large negative element breaks continuity.");
}

@Test
void testCircularArray_LargePositiveAtEnds() {
    int[] nums = {10, -3, -4, 7, 6, 5, -4, -1};
    assertEquals(23, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on circular wrap with large positives at ends.");
}

@Test
void testCircularArray_NegativeThenPositive() {
    int[] nums = {-2, 4, -5, 4, -5, 9, 4};
    assertEquals(15, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on mixed negative-positive where wrap is optimal.");
}

@Test
void testCircularArray_OnlyOneWrapCase() {
    int[] nums = {-1, 3, -2, 3};
    assertEquals(5, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed where only wrap gives the max sum.");
}

@Test
void testCircularArray_AlternatingPosNeg() {
    int[] nums = {5, -2, 5, -2, 5};
    assertEquals(13, KadaneMaxSumSubArray.maxSubarraySumCircular(nums), "Failed on alternating positive and negative values.");
}

}