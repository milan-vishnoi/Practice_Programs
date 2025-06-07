package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

    
}
