package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

    // --- Test Cases for hammingWeight (LeetCode 191) ---

    @Test
    void testHammingWeight_Example1() {
        int n = 0b00000000000000000000000000001011;
        int expected = 3;
        assertEquals(expected, BitManipulation.hammingWeight(n));
    }

    @Test
    void testHammingWeight_Example2() {
        int n = 0b00000000000000000000000010000000;
        int expected = 1;
        assertEquals(expected, BitManipulation.hammingWeight(n));
    }

    @Test
    void testHammingWeight_Example3() {
        int n = 0b11111111111111111111111111111101;
        int expected = 31;
        assertEquals(expected, BitManipulation.hammingWeight(n));
    }

    @Test
    void testHammingWeight_Zero() {
        int n = 0;
        int expected = 0;
        assertEquals(expected, BitManipulation.hammingWeight(n));
    }

    @Test
    void testHammingWeight_AllOnes() {
        int n = -1;
        int expected = 32;
        assertEquals(expected, BitManipulation.hammingWeight(n));
    }

    @Test
    void testHammingWeight_SingleOneAtLeftmost() {
        int n = 0b10000000000000000000000000000000;
        int expected = 1;
        assertEquals(expected, BitManipulation.hammingWeight(n));
    }

    @Test
    void testHammingWeight_SingleOneAtRightmost() {
        int n = 1;
        int expected = 1;
        assertEquals(expected, BitManipulation.hammingWeight(n));
    }

    @Test
    void testHammingWeight_AlternatingBits() {
        int n = 0xAAAAAAAA;
        int expected = 16;
        assertEquals(expected, BitManipulation.hammingWeight(n));

        n = 0x55555555;
        expected = 16;
        assertEquals(expected, BitManipulation.hammingWeight(n));
    }

    @Test
    void testHammingWeight_PowersOfTwo() {
        int n = 2;
        int expected = 1;
        assertEquals(expected, BitManipulation.hammingWeight(n));

        n = 4;
        expected = 1;
        assertEquals(expected, BitManipulation.hammingWeight(n));

        n = 16;
        expected = 1;
        assertEquals(expected, BitManipulation.hammingWeight(n));

        n = 1073741824;
        expected = 1;
        assertEquals(expected, BitManipulation.hammingWeight(n));
    }

    // --- Test Cases for countBits (LeetCode 338) ---

    @Test
    void testCountBits_Example1() {
        int n = 2;
        int[] expected = {0, 1, 1};
        assertArrayEquals(expected, BitManipulation.countBits(n));
    }

    @Test
    void testCountBits_Example2() {
        int n = 5;
        int[] expected = {0, 1, 1, 2, 1, 2};
        assertArrayEquals(expected, BitManipulation.countBits(n));
    }

    @Test
    void testCountBits_Zero() {
        int n = 0;
        int[] expected = {0};
        assertArrayEquals(expected, BitManipulation.countBits(n));
    }

    @Test
    void testCountBits_One() {
        int n = 1;
        int[] expected = {0, 1};
        assertArrayEquals(expected, BitManipulation.countBits(n));
    }

    @Test
    void testCountBits_PowersOfTwo() {
        int n = 4;
        int[] expected = {0, 1, 1, 2, 1};
        assertArrayEquals(expected, BitManipulation.countBits(n));

        n = 8;
        int[] expected2 = {0, 1, 1, 2, 1, 2, 2, 3, 1};
        assertArrayEquals(expected2, BitManipulation.countBits(n));
    }

    @Test
    void testCountBits_MaxNValue() {
        int n = 100000;
        int[] result = BitManipulation.countBits(n);
        assertEquals(n + 1, result.length);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(1, result[2]);
        assertEquals(2, result[3]);
        assertEquals(1, result[4]);
    }
    
}
