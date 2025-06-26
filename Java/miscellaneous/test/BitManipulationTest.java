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

    // --- Test Cases for getSum (LeetCode 371) ---

    @Test
    void testGetSum_Example1() {
        int a = 1;
        int b = 2;
        int expected = 3;
        assertEquals(expected, BitManipulation.getSum(a, b));
    }

    @Test
    void testGetSum_Example2() {
        int a = 2;
        int b = 3;
        int expected = 5;
        assertEquals(expected, BitManipulation.getSum(a, b));
    }

    @Test
    void testGetSum_PositiveAndNegative() {
        int a = 5;
        int b = -3;
        int expected = 2;
        assertEquals(expected, BitManipulation.getSum(a, b));
    }

    @Test
    void testGetSum_NegativeAndPositive() {
        int a = -5;
        int b = 3;
        int expected = -2;
        assertEquals(expected, BitManipulation.getSum(a, b));
    }

    @Test
    void testGetSum_BothNegative() {
        int a = -5;
        int b = -3;
        int expected = -8;
        assertEquals(expected, BitManipulation.getSum(a, b));
    }

    @Test
    void testGetSum_ZeroAndNumber() {
        int a = 0;
        int b = 10;
        int expected = 10;
        assertEquals(expected, BitManipulation.getSum(a, b));

        a = -7;
        b = 0;
        expected = -7;
        assertEquals(expected, BitManipulation.getSum(a, b));
    }

    @Test
    void testGetSum_BothZero() {
        int a = 0;
        int b = 0;
        int expected = 0;
        assertEquals(expected, BitManipulation.getSum(a, b));
    }

    @Test
    void testGetSum_MaxIntAndOne() {
        int a = Integer.MAX_VALUE; // 2147483647
        int b = 1;
        int expected = Integer.MIN_VALUE; // -2147483648
        assertEquals(expected, BitManipulation.getSum(a, b));
    }

    @Test
    void testGetSum_MinIntAndNegativeOne() {
        int a = Integer.MIN_VALUE; // -2147483648
        int b = -1;
        int expected = Integer.MAX_VALUE; // 2147483647
        assertEquals(expected, BitManipulation.getSum(a, b));
    }

    @Test
    void testGetSum_LargeNegativeNumbers() {
        int a = -1_000_000_000;
        int b = -1_500_000_000;
        int expected = a + b;
        assertEquals(expected, BitManipulation.getSum(a, b));
    }

    // --- Test Cases for singleNumberTriple (LeetCode 137) ---

    @Test
    void testSingleNumberTriple_Example1() {
        int[] nums = {2, 2, 3, 2};
        int expected = 3;
        assertEquals(expected, BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_Example2() {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        int expected = 99;
        assertEquals(expected, BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_SingleElement() {
        int[] nums = {7};
        int expected = 7;
        assertEquals(expected, BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_NegativeNumbers() {
        int[] nums = {-2, -2, -3, -2};
        int expected = -3;
        assertEquals(expected, BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_MixedNumbersWithZero() {
        int[] nums = {1, 1, 1, 0, 2, 2, 2};
        int expected = 0;
        assertEquals(expected, BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_LargeNumbers() {
        int[] nums = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 123456789};
        int expected = 123456789;
        assertEquals(expected, BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_MinInt() {
        int[] nums = {-1, -1, -1, Integer.MIN_VALUE};
        int expected = Integer.MIN_VALUE;
        assertEquals(expected, BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_LongArray() {
        int[] nums = new int[3 * 100 + 1]; // 301 elements
        for (int i = 0; i < 100; i++) {
            nums[3 * i] = i + 1;
            nums[3 * i + 1] = i + 1;
            nums[3 * i + 2] = i + 1;
        }
        nums[300] = 500; // The single number
        int expected = 500;
        assertEquals(expected, BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_SingleNumberAtStart() {
        int[] nums = {10, 20, 30, 20, 30, 20, 30};
        int expected = 10;
        assertEquals(expected, BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_SingleNumberAtEnd() {
        int[] nums = {1, 2, 1, 2, 1, 2, 5};
        int expected = 5;
        assertEquals(expected, BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_NullArray() {
        int[] nums = null;
        assertThrows(NullPointerException.class, () -> BitManipulation.singleNumberTriple(nums));
    }

    @Test
    void testSingleNumberTriple_EmptyArray() {
        int[] nums = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> BitManipulation.singleNumberTriple(nums));
    }

    // --- Test Cases for rangeBitwiseAnd (LeetCode 201) ---

    @Test
    void testRangeBitwiseAnd_Example1() {
        int left = 5;
        int right = 7;
        int expected = 4; // (101 & 110 & 111) = 100
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    @Test
    void testRangeBitwiseAnd_Example2() {
        int left = 0;
        int right = 0;
        int expected = 0;
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    @Test
    void testRangeBitwiseAnd_Example3() {
        int left = 1;
        int right = 2147483647; // Integer.MAX_VALUE
        int expected = 0;
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    @Test
    void testRangeBitwiseAnd_SameNumber() {
        int left = 10;
        int right = 10;
        int expected = 10;
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    @Test
    void testRangeBitwiseAnd_ConsecutiveNumbers() {
        int left = 8; // 1000
        int right = 9; // 1001
        int expected = 8; // 1000 & 1001 = 1000
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    @Test
    void testRangeBitwiseAnd_PowerOfTwoRange() {
        int left = 8; // 1000
        int right = 15; // 1111
        int expected = 8; // (1000 & 1001 & ... & 1111) = 1000
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    @Test
    void testRangeBitwiseAnd_RangeCrossingPowerOfTwo() {
        int left = 7; // 0111
        int right = 8; // 1000
        int expected = 0; // (0111 & 1000) = 0000
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    @Test
    void testRangeBitwiseAnd_LargeRange() {
        int left = 100;
        int right = 120;
        int expected = 96;
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    @Test
    void testRangeBitwiseAnd_MaxIntValues() {
        int left = Integer.MAX_VALUE - 1; // 2147483646
        int right = Integer.MAX_VALUE;   // 2147483647
        // ...1111110 & ...1111111 = ...1111110
        int expected = Integer.MAX_VALUE - 1;
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    @Test
    void testRangeBitwiseAnd_LargeGapSamePrefix() {
        int left = 16; // 10000
        int right = 31; // 11111
        int expected = 16;
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    @Test
    void testRangeBitwiseAnd_LargeGapDifferentPrefix() {
        int left = 15; // 01111
        int right = 16; // 10000
        int expected = 0;
        assertEquals(expected, BitManipulation.rangeBitwiseAnd(left, right));
    }

    // --- Test Cases for reverseBits (LeetCode 190) ---

    @Test
    void testReverseBits_Example1() {
        int n = 0b00000010100101000001111010011100;
        int expected = 0b00111001011110000010100101000000;
        assertEquals(expected, BitManipulation.reverseBits(n));
    }

    @Test
    void testReverseBits_Zero() {
        int n = 0;
        int expected = 0;
        assertEquals(expected, BitManipulation.reverseBits(n));
    }

    @Test
    void testReverseBits_One() {
        int n = 1;
        int expected = Integer.MIN_VALUE;
        assertEquals(expected, BitManipulation.reverseBits(n));
    }

    @Test
    void testReverseBits_MaxInt() {
        int n = Integer.MAX_VALUE;
        int expected = -2;
        assertEquals(expected, BitManipulation.reverseBits(n));
    }

    @Test
    void testReverseBits_MinInt() {
        int n = Integer.MIN_VALUE;
        int expected = 1;
        assertEquals(expected, BitManipulation.reverseBits(n));
    }

    @Test
    void testReverseBits_AllOnes() {
        int n = -1;
        int expected = -1;
        assertEquals(expected, BitManipulation.reverseBits(n));
    }

    @Test
    void testReverseBits_SimplePattern() {
        int n = 0b00000000000000000000000000001111;
        int expected = 0b11110000000000000000000000000000;
        assertEquals(expected, BitManipulation.reverseBits(n));
    }

    @Test
    void testReverseBits_AnotherSimplePattern() {
        int n = 0b10000000000000000000000000000001;
        int expected = 0b10000000000000000000000000000001;
        assertEquals(expected, BitManipulation.reverseBits(n));
    }

    @Test
    void testReverseBits_PalindromicPattern() {
        int n = 0b10011001100110011001100110011001;
        int expected = 0b10011001100110011001100110011001;
        assertEquals(expected, BitManipulation.reverseBits(n));
    }
    
}
