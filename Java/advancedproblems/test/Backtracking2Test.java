package advancedproblems.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import advancedproblems.Backtracking2;



public class Backtracking2Test {

    private List<String> sortStrings(List<String> list) {
        Collections.sort(list);
        return list;
    }

    // --- Test Cases for letterCombinations (LeetCode 17) ---

    @Test
    void testLetterCombinations_Example1() {
        String digits = "23";
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.letterCombinations(digits)));
    }

    @Test
    void testLetterCombinations_EmptyString() {
        String digits = "";
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.letterCombinations(digits)));
    }

    @Test
    void testLetterCombinations_Example2() {
        String digits = "2";
        List<String> expected = Arrays.asList("a", "b", "c");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.letterCombinations(digits)));
    }

    @Test
    void testLetterCombinations_DigitsWithNoLetters() {
        String digits = "1";
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.letterCombinations(digits)));
    }

    @Test
    void testLetterCombinations_AllDigits() {
        String digits = "234";
        List<String> result = Backtracking2.letterCombinations(digits);
        assertEquals(3 * 3 * 3, result.size());
        assertTrue(sortStrings(result).containsAll(Arrays.asList("adg", "cfi")));
    }

    @Test
    void testLetterCombinations_LongerInput() {
        String digits = "789";
        List<String> result = Backtracking2.letterCombinations(digits);
        assertEquals(4 * 3 * 4, result.size()); // pqrs, tuv, wxyz
        assertTrue(sortStrings(result).containsAll(Arrays.asList("ptw", "pux", "svx")));
    }

    @Test
    void testLetterCombinations_MaxConstraintLength() {
        String digits = "23456789";
        List<String> result = Backtracking2.letterCombinations(digits);
        assertEquals(3*3*3*3*3*4*3*4, result.size());
    }

    @Test
    void testLetterCombinations_NullInput() {
        String digits = null;
        assertThrows(NullPointerException.class, () -> Backtracking2.letterCombinations(digits));
    }
}
