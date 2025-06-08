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

    
}
