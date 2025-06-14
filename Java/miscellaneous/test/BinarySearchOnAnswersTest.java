package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import miscellaneous.BinarySearchOnAnswers;


public class BinarySearchOnAnswersTest {

    // --- Test Cases for minEatingSpeed (LeetCode 875) ---

    @Test
    void testMinEatingSpeed_Example1() {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int expected = 4;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 1 Failed: Example 1");
    }

    @Test
    void testMinEatingSpeed_Example2() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        int expected = 30;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 2 Failed: Example 2 - Tightly constrained h");
    }

    @Test
    void testMinEatingSpeed_Example3() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        int expected = 23;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 3 Failed: Example 3 - Slightly more flexible h");
    }

    @Test
    void testMinEatingSpeed_SmallestH_MaxPileSpeed() {
        int[] piles = {10, 20, 30};
        int h = 3;
        int expected = 30;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 4 Failed: h equals piles.length");
    }

    @Test
    void testMinEatingSpeed_LargestH_MinSpeedOne() {
        int[] piles = {1, 2, 3};
        int h = 100;
        int expected = 1;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 5 Failed: h is very large");
    }

    @Test
    void testMinEatingSpeed_SinglePile() {
        int[] piles = {100};
        int h = 3;
        int expected = 34;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 6 Failed: Single pile, h > 1");
    }

    @Test
    void testMinEatingSpeed_SinglePile_HIsOne() {
        int[] piles = {100};
        int h = 1;
        int expected = 100;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 7 Failed: Single pile, h = 1");
    }

    @Test
    void testMinEatingSpeed_AllPilesSameSize() {
        int[] piles = {8, 8, 8, 8};
        int h = 4;
        int expected = 8;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 8 Failed: All piles same size, exact h");
    }

    @Test
    void testMinEatingSpeed_AllPilesSameSize_HFlexible() {
        int[] piles = {8, 8, 8, 8};
        int h = 7;
        int expected = 5;
        expected = 8;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 9 Failed: All piles same size, flexible h");
    }

    @Test
    void testMinEatingSpeed_EmptyPiles() {
        int[] piles = {};
        int h = 5;
        int expected = 0;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 10 Failed: Empty piles array");
    }

    @Test
    void testMinEatingSpeed_NullPiles() {
        int[] piles = null;
        int h = 5;
        assertThrows(NullPointerException.class, () -> BinarySearchOnAnswers.minEatingSpeed(piles, h),
                "Test Case 11 Failed: Null piles array should throw NPE");
    }

    @Test
    void testMinEatingSpeed_LargeNumbers() {
        int[] piles = {1_000_000_000, 1_000_000_000};
        int h = 2;
        int expected = 1_000_000_000;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 12 Failed: Large pile sizes, small h");
    }

    @Test
    void testMinEatingSpeed_LargeNumbers_LargeH() {
        int[] piles = {1_000_000_000, 1_000_000_000};
        int h = 2_000_000_000;
        int expected = 1;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 13 Failed: Large pile sizes, large h");
    }

    @Test
    void testMinEatingSpeed_MixedPileSizes() {
        int[] piles = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int h = 10;
        int expected = 10;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 14 Failed: Mixed pile sizes, h = piles.length");
    }

    @Test
    void testMinEatingSpeed_MixedPileSizes_H_Between() {
        int[] piles = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int h = 15;
        int expected = 5;
        assertEquals(expected, BinarySearchOnAnswers.minEatingSpeed(piles, h), "Test Case 15 Failed: Mixed pile sizes, h is intermediate");
    }

  // --- Test Cases for splitArray (LeetCode 410) ---

    @Test
    void testSplitArray_Example1() {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        int expected = 18;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 1 Failed: Example 1");
    }

    @Test
    void testSplitArray_Example2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        int expected = 17;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 2 Failed: Example 2");
    }

    @Test
    void testSplitArray_Example3() {
        int[] nums = {1, 4, 4};
        int k = 3;
        int expected = 4;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 3 Failed: Example 3");
    }

    @Test
    void testSplitArray_KEqualsOne() {
        int[] nums = {10, 20, 30, 40};
        int k = 1;
        int expected = 100;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 4 Failed: k = 1");
    }

    @Test
    void testSplitArray_KEqualsNumLength() {
        int[] nums = {10, 2, 8, 15, 5};
        int k = 5;
        int expected = 15;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 5 Failed: k = nums.length");
    }

    @Test
    void testSplitArray_AllSameElements() {
        int[] nums = {5, 5, 5, 5, 5};
        int k = 3;
        int expected = 10;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 6 Failed: All same elements");
    }

    @Test
    void testSplitArray_ContainsZeros() {
        int[] nums = {0, 0, 0, 100, 0, 0};
        int k = 3;
        int expected = 100;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 7 Failed: Contains zeros");
    }

    @Test
    void testSplitArray_SingleElementArray() {
        int[] nums = {42};
        int k = 1;
        int expected = 42;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 8 Failed: Single element array");
    }

    @Test
    void testSplitArray_LargeNumbers() {
        int[] nums = {1000000, 1000000, 1000000};
        int k = 2;
        int expected = 2000000;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 9 Failed: Large numbers");
    }

    @Test
    void testSplitArray_LongArray() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // 20 ones
        int k = 5;
        // Each sub-array will have sum 4. 20/5 = 4 elements per sub-array.
        int expected = 4;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 10 Failed: Long array, even split");
    }

    @Test
    void testSplitArray_LongArrayUnevenSplit() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; // Sum = 210
        int k = 7;
        int expected = 37;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 11 Failed: Long array, uneven split");
    }

    @Test
    void testSplitArray_NullArray() {
        int[] nums = null;
        int k = 2;
        assertThrows(NullPointerException.class, () -> BinarySearchOnAnswers.splitArray(nums, k),
                "Test Case 12 Failed: Null array should throw NPE");
    }

    @Test
    void testSplitArray_KGreaterThanNumsLength() {
        int[] nums = {1, 2, 3};
        int k = 5;
        int expected = 3;
        assertEquals(expected, BinarySearchOnAnswers.splitArray(nums, k), "Test Case 13 Failed: k > nums.length (if allowed)");
    }
}