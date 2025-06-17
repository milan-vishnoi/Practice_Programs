package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import miscellaneous.BinarySearchOnAnswers;


public class BinarySearchOnAnswersTest {

     private static final double DELTA = 1e-9;

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

// --- Test Cases for findMedianSortedArrays ---

    @Test
    void testFindMedianSortedArrays_Example1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0; // Merged: [1, 2, 3]. Median is 2.
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 1 Failed: Example 1 (Odd total length)");
    }

    @Test
    void testFindMedianSortedArrays_Example2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5; 
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 2 Failed: Example 2 (Even total length)");
    }

    @Test
    void testFindMedianSortedArrays_OneArrayEmpty_Nums1Empty() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5};
        double expected = 3.0;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 3 Failed: nums1 is empty");
    }

    @Test
    void testFindMedianSortedArrays_OneArrayEmpty_Nums2Empty() {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {};
        double expected = 3.5; 
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 4 Failed: nums2 is empty");
    }

    @Test
    void testFindMedianSortedArrays_SingleElements() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 5 Failed: Single elements");
    }

    @Test
    void testFindMedianSortedArrays_AllElementsInOneArraySmaller() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {10, 20, 30};
        double expected = 6.5;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 6 Failed: All elements in nums1 smaller");
    }

    @Test
    void testFindMedianSortedArrays_AllElementsInOneArrayLarger() {
        int[] nums1 = {10, 20, 30};
        int[] nums2 = {1, 2, 3};
        double expected = 6.5; 
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 7 Failed: All elements in nums2 smaller");
    }

    @Test
    void testFindMedianSortedArrays_OverlappingRanges() {
        int[] nums1 = {1, 5, 8, 10, 15};
        int[] nums2 = {2, 3, 9, 12, 18};
        double expected = 8.5;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 8 Failed: Overlapping ranges");
    }

    @Test
    void testFindMedianSortedArrays_ArraysWithDuplicates() {
        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {2, 3, 4, 4};

        double expected = 2.5;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 9 Failed: Arrays with duplicates");
    }

    @Test
    void testFindMedianSortedArrays_ComplexMixedOddLength() {
        int[] nums1 = {1, 2, 4, 6};
        int[] nums2 = {3, 5, 7};

        double expected = 4.0;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 10 Failed: Complex mixed odd length");
    }

    @Test
    void testFindMedianSortedArrays_ComplexMixedEvenLength() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {5, 6, 7, 8};

        double expected = 4.5;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 11 Failed: Complex mixed even length");
    }

    @Test
    void testFindMedianSortedArrays_LargeNumbers() {
        int[] nums1 = {1_000_000, 2_000_000};
        int[] nums2 = {1_500_000, 2_500_000};

        double expected = 1_750_000.0;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 12 Failed: Large numbers");
    }

    @Test
    void testFindMedianSortedArrays_MixedLengths_Odd() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7};         
        double expected = 4.0;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 13 Failed: Mixed lengths (odd total)");
    }

    @Test
    void testFindMedianSortedArrays_MixedLengths_Even() {
        int[] nums1 = {1, 2, 3};  
        int[] nums2 = {4, 5, 6, 7}; 

        double expected = 4.0;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 14 Failed: Mixed lengths (even total)");
    }

    @Test
    void testFindMedianSortedArrays_EdgeCase_EmptyNums1() {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        double expected = 2.5;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 15 Failed: Empty nums1, two elements in nums2");
    }

    @Test
    void testFindMedianSortedArrays_EdgeCase_EmptyNums2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {};
        double expected = 1.5;
        assertEquals(expected, BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2), DELTA, "Test Case 16 Failed: Empty nums2, two elements in nums1");
    }

    @Test
    void testFindMedianSortedArrays_NullNums1() {
        int[] nums1 = null;
        int[] nums2 = {1, 2};
        assertThrows(NullPointerException.class, () -> BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2),
                "Test Case 17 Failed: Null nums1 should throw NPE");
    }

    @Test
    void testFindMedianSortedArrays_NullNums2() {
        int[] nums1 = {1, 2};
        int[] nums2 = null;
        assertThrows(NullPointerException.class, () -> BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2),
                "Test Case 18 Failed: Null nums2 should throw NPE");
    }

    @Test
    void testFindMedianSortedArrays_BothNullArrays() {
        int[] nums1 = null;
        int[] nums2 = null;
        assertThrows(NullPointerException.class, () -> BinarySearchOnAnswers.findMedianSortedArrays(nums1, nums2),
                "Test Case 19 Failed: Both null arrays should throw NPE");
    }

    // --- Test Cases for shipWithinDays (LeetCode 1011) ---

    @Test
    void testShipWithinDays_Example1() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int expected = 15;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 1 Failed: Example 1");
    }

    @Test
    void testShipWithinDays_Example2() {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;
        int expected = 6;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 2 Failed: Example 2");
    }

    @Test
    void testShipWithinDays_Example3() {
        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;
        int expected = 3;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 3 Failed: Example 3");
    }

    @Test
    void testShipWithinDays_DaysEqualsWeightsLength() {
        int[] weights = {10, 5, 8, 20};
        int days = 4;
        int expected = 20;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 4 Failed: days = weights.length");
    }

    @Test
    void testShipWithinDays_DaysEqualsOne() {
        int[] weights = {10, 5, 8, 20};
        int days = 1;
        int expected = 43;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 5 Failed: days = 1");
    }

    @Test
    void testShipWithinDays_SinglePackage() {
        int[] weights = {42};
        int days = 1;
        int expected = 42;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 6 Failed: Single package, 1 day");

        weights = new int[]{42};
        days = 10;
        expected = 42;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 7 Failed: Single package, many days");
    }

    @Test
    void testShipWithinDays_AllPackagesSameWeight() {
        int[] weights = {5, 5, 5, 5, 5};
        int days = 3;
        int expected = 10;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 8 Failed: All packages same weight");
    }

    @Test
    void testShipWithinDays_WeightsExactlyFit() {
        int[] weights = {4, 5, 6, 7, 8};
        int days = 3;
        int expected = 13;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 9 Failed: Weights exactly fit a capacity");
    }

    @Test
    void testShipWithinDays_LongArray() {
        int[] weights = new int[50000];
        Arrays.fill(weights, 1);
        int days = 1000;

        int expected = 50;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 10 Failed: Long array, even distribution");
    }

    @Test
    void testShipWithinDays_LongArrayMixedWeights() {
        int[] weights = new int[200];
        for (int i = 0; i < 100; i++) weights[i] = 1;
        for (int i = 100; i < 200; i++) weights[i] = 500; // Mix small and large weights
        int days = 50;

        int expected = 1100;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 11 Failed: Long array, mixed weights");
    }

    @Test
    void testShipWithinDays_NullWeights() {
        int[] weights = null;
        int days = 5;

        assertThrows(NullPointerException.class, () -> BinarySearchOnAnswers.shipWithinDays(weights, days),
                "Test Case 12 Failed: Null weights array should throw NPE");
    }

    @Test
    void testShipWithinDays_MinCapacityIsMaxWeight() {
        int[] weights = {1, 2, 100, 3, 4};
        int days = 2;

        int expected = 103;
        assertEquals(expected, BinarySearchOnAnswers.shipWithinDays(weights, days), "Test Case 13 Failed: Minimum capacity is max weight");
    }

// --- Test Cases for smallestDivisor (LeetCode 1283) ---

    @Test
    void testSmallestDivisor_Example1() {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        int expected = 5;
        assertEquals(expected, new BinarySearchOnAnswers().smallestDivisor(nums, threshold), "Test Case 1 Failed: Example 1");
    }

    @Test
    void testSmallestDivisor_Example2() {
        int[] nums = {44, 22, 33, 11, 1};
        int threshold = 5;
        int expected = 44;
        assertEquals(expected, new BinarySearchOnAnswers().smallestDivisor(nums, threshold), "Test Case 2 Failed: Example 2");
    }

    @Test
    void testSmallestDivisor_Example3() {
        int[] nums = {21212, 10101, 12121};
        int threshold = 1000;
        int expected = 44;
        assertEquals(expected, new BinarySearchOnAnswers().smallestDivisor(nums, threshold), "Test Case 3 Failed: Example 3 (Large numbers)");
    }

    @Test
    void testSmallestDivisor_ThresholdEqualsNumsLength() {
        int[] nums = {10, 2, 8, 15, 5};
        int threshold = 5;
        int expected = 15;
        assertEquals(expected, new BinarySearchOnAnswers().smallestDivisor(nums, threshold), "Test Case 4 Failed: threshold = nums.length");
    }

    @Test
    void testSmallestDivisor_ThresholdVeryLarge() {
        int[] nums = {1, 2, 3, 4, 5};
        int threshold = 100;
        int expected = 1;
        assertEquals(expected, new BinarySearchOnAnswers().smallestDivisor(nums, threshold), "Test Case 5 Failed: threshold is very large");
    }

    @Test
    void testSmallestDivisor_SingleElement() {
        int[] nums = {100};
        int threshold = 5;
        int expected = 20;
        assertEquals(expected, new BinarySearchOnAnswers().smallestDivisor(nums, threshold), "Test Case 6 Failed: Single element");
    }

    @Test
    void testSmallestDivisor_AllOnes() {
        int[] nums = {1, 1, 1, 1, 1};
        int threshold = 5;
        int expected = 1;
        assertEquals(expected, new BinarySearchOnAnswers().smallestDivisor(nums, threshold), "Test Case 7 Failed: All ones, threshold=length");
    }

    @Test
    void testSmallestDivisor_AllSameNonOne() {
        int[] nums = {10, 10, 10, 10};
        int threshold = 4;
        int expected = 10;
        assertEquals(expected, new BinarySearchOnAnswers().smallestDivisor(nums, threshold), "Test Case 8 Failed: All same non-one, threshold=length");
    }

    @Test
    void testSmallestDivisor_LongArrayMixedValues() {
        int[] nums = new int[50000];
        for (int i = 0; i < 25000; i++) nums[i] = 1;
        for (int i = 25000; i < 50000; i++) nums[i] = 100;
        int threshold = 50000;
        int expected = 100;
        assertEquals(expected, new BinarySearchOnAnswers().smallestDivisor(nums, threshold), "Test Case 9 Failed: Long array, mixed values, threshold=nums.length");
    }

    @Test
    void testSmallestDivisor_NullNums() {
        int[] nums = null;
        int threshold = 5;
        assertThrows(NullPointerException.class, () -> new BinarySearchOnAnswers().smallestDivisor(nums, threshold),
                "Test Case 10 Failed: Null nums array should throw NPE");
    }
}