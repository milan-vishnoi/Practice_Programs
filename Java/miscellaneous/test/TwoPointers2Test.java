package miscellaneous.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import miscellaneous.TwoPointers2;

import java.util.Arrays;

public class TwoPointers2Test {

    // Helper method to extract the relevant part of the array for comparison
    private int[] getSubArray(int[] array, int length) {
        if (array == null || length < 0 || length > array.length) {
            // Handle invalid length or null array for safety, though test cases should provide valid ones
            return new int[0];
        }
        return Arrays.copyOfRange(array, 0, length);
    }

    // --- Test Cases for removeDuplicates (LeetCode 80: Remove Duplicates from Sorted Array II) ---

    @Test
    void testRemoveDuplicatesII_Example1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int expectedLength = 3;
        int[] expectedNums = {1, 2, 3};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 1 Failed: Length mismatch for example 1");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 1 Failed: Array content mismatch for example 1");
    }

    @Test
    void testRemoveDuplicatesII_Example2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int expectedLength = 4;
        int[] expectedNums = {0,1, 2, 3};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 2 Failed: Length mismatch for example 2");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 2 Failed: Array content mismatch for example 2");
    }

    @Test
    void testRemoveDuplicatesII_EmptyArray() {
        int[] nums = {};
        int expectedLength = 0;
        int[] expectedNums = {};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 3 Failed: Length mismatch for empty array");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 3 Failed: Array content mismatch for empty array");
    }

    @Test
    void testRemoveDuplicatesII_SingleElement() {
        int[] nums = {5};
        int expectedLength = 1;
        int[] expectedNums = {5};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 4 Failed: Length mismatch for single element");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 4 Failed: Array content mismatch for single element");
    }

    @Test
    void testRemoveDuplicatesII_TwoElements_Unique() {
        int[] nums = {1, 2};
        int expectedLength = 2;
        int[] expectedNums = {1, 2};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 5 Failed: Length mismatch for two unique elements");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 5 Failed: Array content mismatch for two unique elements");
    }

    @Test
    void testRemoveDuplicatesII_TwoElements_Duplicate() {
        int[] nums = {3, 3};
        int expectedLength = 1;
        int[] expectedNums = {3};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 6 Failed: Length mismatch for two duplicate elements");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 6 Failed: Array content mismatch for two duplicate elements");
    }

    @Test
    void testRemoveDuplicatesII_AllUniqueElements() {
        int[] nums = {1, 2, 3, 4, 5};
        int expectedLength = 5;
        int[] expectedNums = {1, 2, 3, 4, 5};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 7 Failed: Length mismatch for all unique elements");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 7 Failed: Array content mismatch for all unique elements");
    }

    @Test
    void testRemoveDuplicatesII_AllSameElements_MoreThanTwo() {
        int[] nums = {7, 7, 7, 7, 7};
        int expectedLength = 1;
        int[] expectedNums = {7};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 8 Failed: Length mismatch for all same elements (more than two)");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 8 Failed: Array content mismatch for all same elements (more than two)");
    }

    @Test
    void testRemoveDuplicatesII_MixedDuplicates() {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5};
        int expectedLength = 5;
        int[] expectedNums = {1, 2, 3, 4, 5};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 9 Failed: Length mismatch for mixed duplicates");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 9 Failed: Array content mismatch for mixed duplicates");
    }

    @Test
    void testRemoveDuplicatesII_NegativeNumbers() {
        int[] nums = {-3, -3, -3, -1, 0, 0, 0, 0, 2, 2, 5};
        int expectedLength = 5;
        int[] expectedNums = {-3, -1, 0, 2,5};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 10 Failed: Length mismatch for negative numbers");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 10 Failed: Array content mismatch for negative numbers");
    }

    @Test
    void testRemoveDuplicatesII_LongArray() {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7, 7, 7, 8, 8, 9, 9, 9, 9};
        int expectedLength = 9;
        int[] expectedNums = {1, 2, 3, 4, 5,  6,  7,  8, 9};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 11 Failed: Length mismatch for long array");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 11 Failed: Array content mismatch for long array");
    }

    @Test
    void testRemoveDuplicatesII_NullArray() {
        int[] nums = null;
        int expectedLength = 0;

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 12 Failed: Length mismatch for null array");
        // No array content assertion needed as nums is null.
    }
}
