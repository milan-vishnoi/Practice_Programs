package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import miscellaneous.SlidingWindow;

public class SlidingWindowTest {

    @Test
    void testBasicPositiveNumbers() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        assertEquals(15, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {4, 5, 6}
    }

    @Test
    void testMixedPositiveAndNegativeNumbers() {
        int[] nums = {-1, 2, 3, -4, 5, -6};
        int k = 3;
        assertEquals(4, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {2, 3, -4}
    }

    @Test
    void testAllNegativeNumbers() {
        int[] nums = {-10, -2, -5, -8, -1};
        int k = 2;
        assertEquals(-7, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {-2, -5}
    }

    @Test
    void testKEqualsOne() {
        int[] nums = {1, 10, 5, 20, 3};
        int k = 1;
        assertEquals(20, SlidingWindow.maxSumKSubArray(nums, k)); // Max single element
    }

    @Test
    void testKEqualsArrayLength() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        assertEquals(15, SlidingWindow.maxSumKSubArray(nums, k)); // Sum of all elements
    }

    @Test
    void testKGreaterThanArrayLength() {
        int[] nums = {1, 2, 3};
        int k = 5;
        assertThrows(IllegalArgumentException.class, () -> SlidingWindow.maxSumKSubArray(nums, k));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int k = 3;
        assertThrows(IllegalArgumentException.class, () -> SlidingWindow.maxSumKSubArray(nums, k));
    }

    @Test
    void testNullArray() {
        int[] nums = null;
        int k = 3;
        assertThrows(IllegalArgumentException.class, () -> SlidingWindow.maxSumKSubArray(nums, k));
    }

    @Test
    void testMaxSumAtBeginning() {
        int[] nums = {10, 20, 1, 2, 3};
        int k = 2;
        assertEquals(30, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {10, 20}
    }

    @Test
    void testMaxSumAtEnd() {
        int[] nums = {1, 2, 3, 10, 20};
        int k = 2;
        assertEquals(30, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {10, 20}
    }

    @Test
    void testMaxSumInMiddle() {
        int[] nums = {1, 2, 10, 20, 3, 4};
        int k = 2;
        assertEquals(30, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {10, 20}
    }

    @Test
    void testDuplicateMaxSums() {
        int[] nums = {1, 5, 2, 5, 1};
        int k = 2;
        assertEquals(7, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {1, 5} or {2, 5}
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {5};
        int k = 1;
        assertEquals(5, SlidingWindow.maxSumKSubArray(nums, k));
    }

    @Test
    void testKIsZero() {
        int[] nums = {1, 2, 3};
        int k = 0;
        assertThrows(IllegalArgumentException.class, () -> SlidingWindow.maxSumKSubArray(nums, k));
    }

    @Test
    void testKIsNegative() {
        int[] nums = {1, 2, 3};
        int k = -2;
        assertThrows(IllegalArgumentException.class, () -> SlidingWindow.maxSumKSubArray(nums, k));
    }
}