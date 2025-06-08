package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import miscellaneous.TwoPointers;

public class TwoPointersTest {

        @Test
    void testTwoSum_Example1() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1, 2}; // 1-based indices
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 1 Failed: Basic example 1");
    }

    @Test
    void testTwoSum_Example2() {
        int[] numbers = {2, 3, 4};
        int target = 6;
        int[] expected = {1, 3}; // 1-based indices
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 2 Failed: Basic example 2");
    }

    @Test
    void testTwoSum_Example3() {
        int[] numbers = {-1, 0};
        int target = -1;
        int[] expected = {1, 2}; // 1-based indices
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 3 Failed: Basic example 3 - Negative numbers");
    }

    @Test
    void testTwoSum_SmallestArray() {
        int[] numbers = {10, 20};
        int target = 30;
        int[] expected = {1, 2};
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 4 Failed: Smallest array");
    }

    @Test
    void testTwoSum_TargetAtExtremes_Small() {
        int[] numbers = {-50, -30, -10, 0, 20, 40};
        int target = -80; // -50 + -30
        int[] expected = {1, 2};
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 5 Failed: Target at small extreme");
    }

    @Test
    void testTwoSum_TargetAtExtremes_Large() {
        int[] numbers = {1, 10, 20, 30, 50, 70};
        int target = 120; // 50 + 70
        int[] expected = {5, 6};
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 6 Failed: Target at large extreme");
    }

    @Test
    void testTwoSum_DuplicatesInArray() {
        int[] numbers = {1, 2, 2, 4, 5};
        int target = 4; 
        int[] expected = {2, 3};
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 7 Failed: Duplicates summing to target");
    }


    @Test
    void testTwoSum_TargetWithZero() {
        int[] numbers = {-3, 0, 3, 5, 7};
        int target = 0; // -3 + 3
        int[] expected = {1, 3};
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 9 Failed: Target is zero");
    }

    @Test
    void testTwoSum_MixedPosNeg() {
        int[] numbers = {-10, -5, 0, 4, 10, 15};
        int target = 0; // -5 + 5
        int[] expected = {1, 5};
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 10 Failed: Mixed positive and negative");
    }

    @Test
    void testTwoSum_LargeValuesNoOverflow() {
        int[] numbers = {100000000, 200000000, 300000000, 400000000};
        int target = 700000000; // 300M + 400M
        int[] expected = {3, 4};
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 11 Failed: Large values");
    }

    @Test
    void testTwoSum_TargetJustAboveFirstElement() {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 3; // 1 + 2
        int[] expected = {1, 2};
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 12 Failed: Target just above first element");
    }

    @Test
    void testTwoSum_TargetJustBelowLastElement() {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 9; // 4 + 5
        int[] expected = {4, 5};
        assertArrayEquals(expected, TwoPointers.twoSum(numbers, target), "TwoSum Test Case 13 Failed: Target just below last element");
    }

        private void assertListsAreEqualIgnoringOrder(List<List<Integer>> expected, List<List<Integer>> actual, String message) {
        // Handle null inputs for robustness (though LeetCode constraints might prevent this)
        if (expected == null && actual == null) {
            return;
        }
        if (expected == null || actual == null) {
            fail("One of the lists is null, but the other is not: Expected=" + expected + ", Actual=" + actual);
        }

        Set<List<Integer>> expectedSet = new HashSet<>();
        for (List<Integer> list : expected) {
            List<Integer> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList); // Sort elements within each triplet
            expectedSet.add(sortedList);
        }

        Set<List<Integer>> actualSet = new HashSet<>();
        for (List<Integer> list : actual) {
            List<Integer> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList); // Sort elements within each triplet from actual result
            actualSet.add(sortedList);
        }

        // Now compare the sets of sorted triplets
        assertEquals(expectedSet, actualSet, message);
    }


    // --- Test Cases for threeSum (LeetCode 15) ---

    @Test
    void testThreeSum_Example1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(-1, -1, 2),
            Arrays.asList(-1, 0, 1)
        );
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 1 Failed: Example 1 from LeetCode");
    }

    @Test
    void testThreeSum_Example2() {
        int[] nums = {0, 1, 1};
        List<List<Integer>> expected = Arrays.asList(); // No triplet sums to 0
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 2 Failed: Example 2 from LeetCode - No solution");
    }

    @Test
    void testThreeSum_Example3() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(0, 0, 0)
        );
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 3 Failed: Example 3 from LeetCode - All zeros");
    }

    @Test
    void testThreeSum_EmptyArray() {
        int[] nums = {};
        List<List<Integer>> expected = Arrays.asList();
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 4 Failed: Empty array input");
    }

    @Test
    void testThreeSum_LessThanThreeElements() {
        int[] nums = {1, 2};
        List<List<Integer>> expected = Arrays.asList();
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 5 Failed: Array with less than 3 elements");
    }

    @Test
    void testThreeSum_ExactlyThreeElementsSumToZero() {
        int[] nums = {-1, 0, 1};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(-1, 0, 1)
        );
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 6 Failed: Exactly three elements summing to zero");
    }

    @Test
    void testThreeSum_ExactlyThreeElementsNotSumToZero() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = Arrays.asList();
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 7 Failed: Exactly three elements not summing to zero");
    }

    @Test
    void testThreeSum_NoSolutionAllPositive() {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> expected = Arrays.asList();
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 8 Failed: No solution, all positive numbers");
    }

    @Test
    void testThreeSum_NoSolutionAllNegative() {
        int[] nums = {-5, -4, -3, -2, -1};
        List<List<Integer>> expected = Arrays.asList();
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 9 Failed: No solution, all negative numbers");
    }

    @Test
    void testThreeSum_DuplicatesHandledCorrectly() {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(-2, 0, 2) // Should only include one unique triplet
        );
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 10 Failed: Duplicates handled correctly");
    }

    @Test
    void testThreeSum_ComplexDuplicatesAndMixedNumbers() {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(-4, -2, 6),
            Arrays.asList(-4, 0, 4),
            Arrays.asList(-4, 1, 3),
            Arrays.asList(-2, -2, 4),
            Arrays.asList(-2, 0, 2),
            Arrays.asList(-4,2,2)
        );
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 11 Failed: Complex duplicates and mixed numbers");
    }

    @Test
    void testThreeSum_LargeRangeOfNumbers() {
        int[] nums = {-100, -50, 0, 50, 100, 150};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(-100, 0, 100),
            Arrays.asList(-50, 0, 50),
            Arrays.asList(-50,-100,150)
        );
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 12 Failed: Large range of numbers");
    }

    @Test
    void testThreeSum_MultipleZeroesPresent() {
        int[] nums = {-1, 0, 0, 0, 1, 2};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(-1, 0, 1),
            Arrays.asList(0, 0, 0)
        );
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 13 Failed: Multiple zeros in input");
    }

    @Test
    void testThreeSum_NullArray() {
        int[] nums = null;
        // As per standard LeetCode behavior for array inputs, typically returns empty list
        // rather than throwing a NullPointerException unless specified.
        List<List<Integer>> expected = Arrays.asList();
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 14 Failed: Null array input");
    }

    @Test
    void testThreeSum_NoSolutionScatteredValues() {
        int[] nums = {-7, -3, 1, 5, 8}; // No triplet here sums to 0
        List<List<Integer>> expected = Arrays.asList();
        assertListsAreEqualIgnoringOrder(expected, TwoPointers.threeSum(nums), "ThreeSum Test Case 15 Failed: No solution with scattered values");
    }

     // --- Test Cases for maxArea (LeetCode 11) ---

    @Test
    void testMaxArea_Example1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected = 49;
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 1 Failed: Example 1 from LeetCode");
    }

    @Test
    void testMaxArea_Example2() {
        int[] height = {1, 1};
        int expected = 1;
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 2 Failed: Example 2 from LeetCode - Two identical heights");
    }

    @Test
    void testMaxArea_IncreasingHeights() {
        int[] height = {1, 2, 3, 4, 5, 6, 7, 8};
        int expected = 7 * 7; // min(1,8) * (7-0) = 1 * 7 = 7. No, min(8,1) * (7-0) = 1*7. Max area is 7*4=28
        // For increasing heights: maxArea(i, j) = min(height[i], height[j]) * (j-i).
        // (1,8) distance 7, min 1 -> area 7
        // (8,7) distance 1, min 7 -> area 7
        // (1,7) distance 6, min 1 -> area 6
        // The optimal pair will always be at the ends (height[0], height[n-1]) or close to it,
        // often the second largest with the largest distance.
        // For {1,2,3,4,5,6,7,8}, the max area is formed by (1,8) => 1*7=7.
        // But if you consider (4,5) at distance 1, it's 4.
        // The two pointers move inward.
        // L=1, R=8, Area=min(1,8)*7 = 7. Move L.
        // L=2, R=8, Area=min(2,8)*6 = 12. Move L.
        // L=3, R=8, Area=min(3,8)*5 = 15. Move L.
        // L=4, R=8, Area=min(4,8)*4 = 16. Move L.
        // L=5, R=8, Area=min(5,8)*3 = 15. Move L.
        // L=6, R=8, Area=min(6,8)*2 = 12. Move L.
        // L=7, R=8, Area=min(7,8)*1 = 7. Move L.
        expected = 16;
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 3 Failed: Increasing heights");
    }

    @Test
    void testMaxArea_DecreasingHeights() {
        int[] height = {8, 7, 6, 5, 4, 3, 2, 1};
        int expected = 16; // Same logic as increasing, symmetric
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 4 Failed: Decreasing heights");
    }

    @Test
    void testMaxArea_AllSameHeights() {
        int[] height = {5, 5, 5, 5, 5};
        int expected = 5 * (5 - 1); // min(5,5) * (4) = 20
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 5 Failed: All same heights");
    }

    @Test
    void testMaxArea_ContainsZeros() {
        int[] height = {0, 2, 0, 4, 0, 6, 0, 8, 0};
        int expected = 8; // min(2,8) * (7-1) = 2 * 6 = 12. No.
        // (0,8) dist 7, min 0 -> area 0
        // (2,8) dist 6, min 2 -> area 12
        // (4,8) dist 4, min 4 -> area 16
        // (6,8) dist 2, min 6 -> area 12
        expected = 16; // from heights 4 and 8
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 6 Failed: Contains zeros");
    }

    @Test
    void testMaxArea_TwoElementsOnly() {
        int[] height = {7, 8};
        int expected = 7; // min(7,8) * (1-0) = 7 * 1 = 7
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 7 Failed: Only two elements");
    }

    @Test
    void testMaxArea_FluctuatingHeights() {
        int[] height = {4, 3, 2, 1, 4};
        int expected = 16;
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 8 Failed: Fluctuating heights");
        int[] height2 = {2,3,4,5,18,17,6};
        assertEquals(17, TwoPointers.maxArea(height2), "MaxArea Test Case 8 Failed: Fluctuating heights");
    }


    @Test
    void testMaxArea_VeryLargeHeights() {
        int[] height = {10000, 1, 2, 3, 4, 5, 6, 10000};
        int expected = 10000 * 7; // min(10000, 10000) * (7-0) = 70000
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 9 Failed: Very large heights");
    }

    @Test
    void testMaxArea_SkewedHeights() {
        int[] height = {1, 2, 100, 3, 4, 5, 99};
        int expected = 396;
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 10 Failed: Skewed heights");
    }

    @Test
    void testMaxArea_NullArray() {
        int[] height = null;
        int expected = 0;
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 11 Failed: Null array input");
    }

    @Test
    void testMaxArea_SingleElementArray() {
        // Problem constraints usually state n >= 2, but for robustness
        int[] height = {5};
        // If n < 2, the area is 0 because no container can be formed.
        int expected = 0;
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 12 Failed: Single element array");
    }

    @Test
    void testMaxArea_ZeroHeightBars() {
        int[] height = {0, 0, 0, 0, 0};
        int expected = 0;
        assertEquals(expected, TwoPointers.maxArea(height), "MaxArea Test Case 13 Failed: All zero height bars");
    }

    
}
