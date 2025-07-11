package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
    
}
