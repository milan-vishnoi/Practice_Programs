package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import miscellaneous.BinarySearchOnSortedArray;

public class BinarySearchOnSortedArrayTest {

    // --- Test Cases for findKthPositive (LeetCode 1539) ---

    @Test
    void testFindKthPositive_Example1() {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int expected = 9;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_Example2() {
        int[] arr = {1, 2, 3, 4};
        int k = 1;
        int expected = 5;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_MissingBeforeArrayStart() {
        int[] arr = {5, 6, 7};
        int k = 3;
        int expected = 3;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_KthMissingAfterArrayEnd() {
        int[] arr = {2, 4};
        int k = 3;
        int expected = 5;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_SingleElementArray() {
        int[] arr = {1};
        int k = 1;
        int expected = 2;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));

        arr = new int[]{10};
        k = 5;
        expected = 5;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_NoMissingInBetween() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int expected = 7;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_LargeKAndArray() {
        int[] arr = {100, 200, 300, 400, 500};
        int k = 1;
        int expected = 1;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));

        arr = new int[]{1, 1000};
        k = 998;
        expected = 999;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_KthMissingJustAfterAnElement() {
        int[] arr = {1, 2, 5, 6};
        int k = 3;
        int expected = 7;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_LongArray() {
        int[] arr = new int[500];
        for (int i = 0; i < 500; i++) {
            arr[i] = i + 1;
        }
        int k = 10;
        int expected = 510;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_LongArrayWithGaps() {
        int[] arr = new int[500];
        for (int i = 0; i < 500; i++) {
            arr[i] = (i + 1) * 2;
        }
        int k = 250;
        int expected = 499;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_NullArray() {
        int[] arr = null;
        int k = 1;
        assertThrows(NullPointerException.class, () -> BinarySearchOnSortedArray.findKthPositive(arr, k));
    }

    @Test
    void testFindKthPositive_KIsVerySmall() {
        int[] arr = {10, 20, 30};
        int k = 1;
        int expected = 1;
        assertEquals(expected, BinarySearchOnSortedArray.findKthPositive(arr, k));
    }
}