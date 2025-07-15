package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

     // --- Test Cases for spiralOrder (LeetCode 54) ---

    @Test
    void testSpiralOrder_Example1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_Example2() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_SingleRow() {
        int[][] matrix = {{1, 2, 3, 4, 5}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_SingleColumn() {
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_SingleElement() {
        int[][] matrix = {{7}};
        List<Integer> expected = Arrays.asList(7);
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_2x2Matrix() {
        int[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> expected = Arrays.asList(1, 2, 4, 3);
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_RectangularMatrixMxN() {
        int[][] matrix = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_RectangularMatrixNxM() {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        List<Integer> expected = Arrays.asList(1, 2, 4, 6, 5, 3);
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_MatrixWithNegativeNumbersAndZeros() {
        int[][] matrix = {{1, -2, 3}, {0, 5, -6}, {-7, 8, 9}};
        List<Integer> expected = Arrays.asList(1, -2, 3, -6, 9, 8, -7, 0, 5);
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_MaximalSizeMatrix10x10() {
        int[][] matrix = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = i * 10 + j + 1;
            }
        }
        List<Integer> result = MathAndSimulation.spiralOrder(matrix);
        assertEquals(100, result.size());
        assertEquals(1, result.get(0));
        assertEquals(10, result.get(9));
        assertEquals(55, result.get(99));
    }

    @Test
    void testSpiralOrder_NullMatrix() {
        int[][] matrix = null;
        assertThrows(NullPointerException.class, () -> MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_EmptyMatrix() {
        int[][] matrix = {};
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    @Test
    void testSpiralOrder_MatrixWithEmptyRows() {
        int[][] matrix = {{}};
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, MathAndSimulation.spiralOrder(matrix));
    }

    // --- Test Cases for setZeroes (LeetCode 73) ---

    @Test
    void testSetZeroes_Example1() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_Example2() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] expected = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_NoZeroes() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_AllZeroes() {
        int[][] matrix = {{0, 0}, {0, 0}};
        int[][] expected = {{0, 0}, {0, 0}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_SingleElementMatrixZero() {
        int[][] matrix = {{0}};
        int[][] expected = {{0}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_SingleElementMatrixNonZero() {
        int[][] matrix = {{5}};
        int[][] expected = {{5}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_ZeroAtTopLeft() {
        int[][] matrix = {{0, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] expected = {{0, 0, 0}, {0, 1, 1}, {0, 1, 1}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_ZeroInFirstRowNotFirstCol() {
        int[][] matrix = {{1, 0, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] expected = {{0, 0, 0}, {1, 0, 1}, {1, 0, 1}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_ZeroInFirstColNotFirstRow() {
        int[][] matrix = {{1, 1, 1}, {0, 1, 1}, {1, 1, 1}};
        int[][] expected = {{0, 1, 1}, {0, 0, 0}, {0, 1, 1}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_MultipleZerosScattered() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 0, 7, 8}, {9, 10, 11, 12}, {13, 14, 0, 16}};
        int[][] expected = {{1, 0, 0, 4}, {0, 0, 0, 0}, {9, 0, 0, 12}, {0, 0, 0, 0}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_RectangularMatrixWithZeros() {
        int[][] matrix = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 1}};
        int[][] expected = {{1, 0, 0, 1}, {0, 0, 0, 0}, {1, 0, 0, 1}, {0, 0, 0, 0}};
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_LargeMatrixWithNegativeValues() {
        int[][] matrix = {
            {10, 20, 30, 40},
            {-5, -6, 0, -8},
            {90, 80, 70, 60},
            {1, 2, 3, 4}
        };
        int[][] expected = {
            {10, 20, 0, 40},
            {0, 0, 0, 0},
            {90, 80, 0, 60},
            {1, 2, 0, 4}
        };
        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_MaximalSizeMatrixWithOneZero() {
        int m = 200;
        int n = 200;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 1;
            }
        }
        matrix[100][100] = 0; // Set a zero in the middle

        int[][] expected = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 100 || j == 100) {
                    expected[i][j] = 0;
                } else {
                    expected[i][j] = 1;
                }
            }
        }

        MathAndSimulation.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testSetZeroes_NullMatrix() {
        int[][] matrix = null;
        assertThrows(NullPointerException.class, () -> MathAndSimulation.setZeroes(matrix));
    }

    @Test
    void testSetZeroes_EmptyMatrix() {
        int[][] matrix = {};
        assertDoesNotThrow(() -> MathAndSimulation.setZeroes(matrix));
        assertArrayEquals(new int[][]{}, matrix);
    }
    // --- Test Cases for isPalindrome (LeetCode 9) ---

    @Test
    void testIsPalindrome_Example1() {
        int x = 121;
        boolean expected = true;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_Example2() {
        int x = -121;
        boolean expected = false;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_Example3() {
        int x = 10;
        boolean expected = false;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_Zero() {
        int x = 0;
        boolean expected = true;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_SingleDigitNonZero() {
        int x = 7;
        boolean expected = true;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_EndsWithZeroNotZeroItself() {
        int x = 100;
        boolean expected = false;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_EvenDigitsPalindrome() {
        int x = 1221;
        boolean expected = true;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_EvenDigitsNonPalindrome() {
        int x = 1234;
        boolean expected = false;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_OddDigitsPalindrome() {
        int x = 12321;
        boolean expected = true;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_OddDigitsNonPalindrome() {
        int x = 12345;
        boolean expected = false;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_LargePalindrome() {
        int x = 2147447412; 
        boolean expected = true;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_MaxIntValue() {
        int x = Integer.MAX_VALUE;
        boolean expected = false;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_MinIntValue() {
        int x = Integer.MIN_VALUE;
        boolean expected = false;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_NegativeNumberEndingInOne() {
        int x = -101;
        boolean expected = false;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    @Test
    void testIsPalindrome_NegativeNumberEndingInZero() {
        int x = -200;
        boolean expected = false;
        assertEquals(expected, MathAndSimulation.isPalindrome(x));
    }

    // --- Test Cases for titleToNumber (LeetCode 171) ---

    @Test
    void testTitleToNumber_Example1() {
        String columnTitle = "A";
        int expected = 1;
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_Example2() {
        String columnTitle = "AB";
        int expected = 28;
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_Example3() {
        String columnTitle = "ZY";
        int expected = 701;
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_Z() {
        String columnTitle = "Z";
        int expected = 26;
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_AA() {
        String columnTitle = "AA";
        int expected = 27;
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_AZ() {
        String columnTitle = "AZ";
        int expected = 52; // 26*1 + 26
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_BA() {
        String columnTitle = "BA";
        int expected = 53; // 26*2 + 1
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_ZZ() {
        String columnTitle = "ZZ";
        int expected = 702; // 26*26 + 26
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_AAA() {
        String columnTitle = "AAA";
        int expected = 703;
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_LongTitle() {
        String columnTitle = "FXSHRXW"; // Corresponds to Integer.MAX_VALUE
        int expected = 2147483647;
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_ShortTitleB() {
        String columnTitle = "B";
        int expected = 2;
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_SmallestValidInput() {
        String columnTitle = "A";
        int expected = 1;
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_SingleCharMax() {
        String columnTitle = "Z";
        int expected = 26;
        assertEquals(expected, MathAndSimulation.titleToNumber(columnTitle));
    }

    @Test
    void testTitleToNumber_NullInput() {
        String columnTitle = null;
        assertThrows(NullPointerException.class, () -> MathAndSimulation.titleToNumber(columnTitle));
    }
    
}
