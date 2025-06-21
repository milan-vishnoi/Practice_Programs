package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import miscellaneous.BitManipulation;

public class BitManipulationTest {

   // --- Test Cases for singleNumber (LeetCode 136) ---

    @Test
    void testSingleNumber_Example1() {
        int[] nums = {2, 2, 1};
        int expected = 1;
        assertEquals(expected, BitManipulation.singleNumber(nums));
    }

    @Test
    void testSingleNumber_Example2() {
        int[] nums = {4, 1, 2, 1, 2};
        int expected = 4;
        assertEquals(expected, BitManipulation.singleNumber(nums));
    }

    @Test
    void testSingleNumber_Example3() {
        int[] nums = {1};
        int expected = 1;
        assertEquals(expected, BitManipulation.singleNumber(nums));
    }

    @Test
    void testSingleNumber_AllSameExceptOne() {
        int[] nums = {7, 3, 4, 3, 4};
        int expected = 7;
        assertEquals(expected, BitManipulation.singleNumber(nums));
    }

    @Test
    void testSingleNumber_LargerNumbers() {
        int[] nums = {100000, 200000, 100000, 300000, 200000};
        int expected = 300000;
        assertEquals(expected, BitManipulation.singleNumber(nums));
    }

    @Test
    void testSingleNumber_NegativeNumbers() {
        int[] nums = {-1, -2, -1, -3, -2};
        int expected = -3;
        assertEquals(expected, BitManipulation.singleNumber(nums));
    }

    @Test
    void testSingleNumber_Zero() {
        int[] nums = {0, 1, 0};
        int expected = 1;
        assertEquals(expected, BitManipulation.singleNumber(nums));
    }

    @Test
    void testSingleNumber_LongArray() {
        int[] nums = new int[999];
        for (int i = 0; i < 499; i++) {
            nums[2 * i] = i + 1;
            nums[2 * i + 1] = i + 1;
        }
        nums[998] = 500;
        int expected = 500;
        assertEquals(expected, BitManipulation.singleNumber(nums));
    }

    @Test
    void testSingleNumber_NullArray() {
        int[] nums = null;
        assertThrows(NullPointerException.class, () -> BitManipulation.singleNumber(nums));
    }

    @Test
    void testSingleNumber_EmptyArray() {
        int[] nums = {};
        assertThrows(IllegalArgumentException.class, () -> BitManipulation.singleNumber(nums));
    }
    
}
