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
}