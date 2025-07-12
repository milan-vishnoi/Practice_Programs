package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import miscellaneous.MathAndSimulation;

public class MathAndSimulationTest {

    // --- Test Cases for plusOne (LeetCode 66) ---

    @Test
    void testPlusOne_Example1() {
        int[] digits = {1, 2, 3};
        int[] expected = {1, 2, 4};
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_Example2() {
        int[] digits = {4, 3, 2, 1};
        int[] expected = {4, 3, 2, 2};
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_Example3() {
        int[] digits = {9};
        int[] expected = {1, 0};
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_SingleDigitNonNine() {
        int[] digits = {5};
        int[] expected = {6};
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_EndsWithNine() {
        int[] digits = {1, 2, 9};
        int[] expected = {1, 3, 0};
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_MultipleNinesAtEnd() {
        int[] digits = {1, 9, 9};
        int[] expected = {2, 0, 0};
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_AllNines() {
        int[] digits = {9, 9, 9};
        int[] expected = {1, 0, 0, 0};
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_Zero() {
        int[] digits = {0};
        int[] expected = {1};
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_LargeNumberNotAllNines() {
        int[] digits = {7, 8, 9, 1, 2, 3, 4, 5, 6, 7};
        int[] expected = {7, 8, 9, 1, 2, 3, 4, 5, 6, 8};
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_LargeNumberEndsWithNine() {
        int[] digits = {7, 8, 9, 1, 2, 3, 4, 5, 6, 9};
        int[] expected = {7, 8, 9, 1, 2, 3, 4, 5, 7, 0};
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_LargestPossibleInputAllNines() {
        int[] digits = new int[100];
        Arrays.fill(digits, 9); // e.g., 99...9 (100 times)
        int[] expected = new int[101];
        expected[0] = 1;
        Arrays.fill(expected, 1, 101, 0); // 100...0 (1 followed by 100 zeros)
        assertArrayEquals(expected, MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_NullInput() {
        int[] digits = null;
        assertThrows(NullPointerException.class, () -> MathAndSimulation.plusOne(digits));
    }

    @Test
    void testPlusOne_EmptyInput() {
        int[] digits = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> MathAndSimulation.plusOne(digits));
    }

   // --- Test Cases for addBinary (LeetCode 67) ---

    @Test
    void testAddBinary_Example1() {
        String a = "11";
        String b = "1";
        String expected = "100";
        assertEquals(expected, MathAndSimulation.addBinary(a, b));
    }

    @Test
    void testAddBinary_Example2() {
        String a = "1010";
        String b = "1011";
        String expected = "10101";
        assertEquals(expected, MathAndSimulation.addBinary(a, b));
    }

    @Test
    void testAddBinary_BothZero() {
        String a = "0";
        String b = "0";
        String expected = "0";
        assertEquals(expected, MathAndSimulation.addBinary(a, b));
    }

    @Test
    void testAddBinary_OneZero() {
        String a = "101";
        String b = "0";
        String expected = "101";
        assertEquals(expected, MathAndSimulation.addBinary(a, b));
    }

    @Test
    void testAddBinary_CarryPropagation() {
        String a = "111";
        String b = "1";
        String expected = "1000";
        assertEquals(expected, MathAndSimulation.addBinary(a, b));
    }

    @Test
    void testAddBinary_LongCarryPropagation() {
        String a = "11111";
        String b = "1";
        String expected = "100000";
        assertEquals(expected, MathAndSimulation.addBinary(a, b));
    }

    @Test
    void testAddBinary_DifferentLengths() {
        String a = "1";
        String b = "10101";
        String expected = "10110";
        assertEquals(expected, MathAndSimulation.addBinary(a, b));
    }

    @Test
    void testAddBinary_EqualLengthsNoCarry() {
        String a = "101";
        String b = "010";
        String expected = "111";
        assertEquals(expected, MathAndSimulation.addBinary(a, b));
    }

    @Test
    void testAddBinary_AllOnesSum() {
        String a = "111";
        String b = "111";
        String expected = "1110";
        assertEquals(expected, MathAndSimulation.addBinary(a, b));
    }

    @Test
    void testAddBinary_LongStrings() {
        String longA = "1111111111111111111111111111111111111111111111111111111111111111";
        String longB = "1";
        String expectedLong = "10000000000000000000000000000000000000000000000000000000000000000";
        assertEquals(expectedLong, MathAndSimulation.addBinary(longA, longB));
    }

    @Test
    void testAddBinary_NullA() {
        String a = null;
        String b = "1";
        assertThrows(NullPointerException.class, () -> MathAndSimulation.addBinary(a, b));
    }

    @Test
    void testAddBinary_NullB() {
        String a = "1";
        String b = null;
        assertThrows(NullPointerException.class, () -> MathAndSimulation.addBinary(a, b));
    }

    // --- Test Cases for convertToTitle (LeetCode 168) ---

    @Test
    void testConvertToTitle_Example1() {
        int columnNumber = 1;
        String expected = "A";
        assertEquals(expected, MathAndSimulation.convertToTitle(columnNumber));
    }

    @Test
    void testConvertToTitle_Example2() {
        int columnNumber = 28;
        String expected = "AB";
        assertEquals(expected, MathAndSimulation.convertToTitle(columnNumber));
    }

    @Test
    void testConvertToTitle_Example3() {
        int columnNumber = 701;
        String expected = "ZY";
        assertEquals(expected, MathAndSimulation.convertToTitle(columnNumber));
    }

    @Test
    void testConvertToTitle_Z() {
        int columnNumber = 26;
        String expected = "Z";
        assertEquals(expected, MathAndSimulation.convertToTitle(columnNumber));
    }

    @Test
    void testConvertToTitle_AA() {
        int columnNumber = 27;
        String expected = "AA";
        assertEquals(expected, MathAndSimulation.convertToTitle(columnNumber));
    }

    @Test
    void testConvertToTitle_AZ() {
        int columnNumber = 52;
        String expected = "AZ";
        assertEquals(expected, MathAndSimulation.convertToTitle(columnNumber));
    }

    @Test
    void testConvertToTitle_BA() {
        int columnNumber = 53;
        String expected = "BA";
        assertEquals(expected, MathAndSimulation.convertToTitle(columnNumber));
    }

    @Test
    void testConvertToTitle_ZZ() {
        int columnNumber = 26 * 26 + 26;
        String expected = "ZZ";
        assertEquals(expected, MathAndSimulation.convertToTitle(columnNumber));
    }

    @Test
    void testConvertToTitle_AAA() {
        int columnNumberAAA = 703;
        String expectedAAA = "AAA";
        assertEquals(expectedAAA, MathAndSimulation.convertToTitle(columnNumberAAA));
    }


    @Test
    void testConvertToTitle_MaxIntMinusOne() {
        int columnNumber = 2147483647;
        String expected = "FXSHRXW";
        assertEquals(expected, MathAndSimulation.convertToTitle(columnNumber));
    }

    @Test
    void testConvertToTitle_SmallestValidInput() {
        int columnNumber = 1;
        String expected = "A";
        assertEquals(expected, MathAndSimulation.convertToTitle(columnNumber));
    }

    @Test
    void testConvertToTitle_JustBelowPowerOf26() {
        int columnNumberYZ = 676;
        String expectedYZ = "YZ";
        assertEquals(expectedYZ, MathAndSimulation.convertToTitle(columnNumberYZ));
    }
    
}
