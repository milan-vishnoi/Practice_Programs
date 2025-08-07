package advancedproblems.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import advancedproblems.Backtracking2;



public class Backtracking2Test {

    private List<String> sortStrings(List<String> list) {
        Collections.sort(list);
        return list;
    }

    private List<List<String>> sortPartitions(List<List<String>> partitions) {
        for (List<String> partition : partitions) {
            Collections.sort(partition);
        }
        Collections.sort(partitions, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> l1, List<String> l2) {
                String s1 = String.join("", l1);
                String s2 = String.join("", l2);
                return s1.compareTo(s2);
            }
        });
        return partitions;
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

       // --- Test Cases for partition (LeetCode 131) ---

    @Test
    void testPartition_Example1() {
        String s = "aab";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a", "a", "b"),
                Arrays.asList("aa", "b")
        );
        assertEquals(sortPartitions(expected), sortPartitions(Backtracking2.partition(s)));
    }

    @Test
    void testPartition_Example2() {
        String s = "a";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );
        assertEquals(sortPartitions(expected), sortPartitions(Backtracking2.partition(s)));
    }

    @Test
    void testPartition_SinglePalindrome() {
        String s = "racecar";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("r", "a", "c", "e", "c", "a", "r"),
                Arrays.asList("racecar"),
                Arrays.asList("r","aceca","r"),
                Arrays.asList("r","a","cec","a","r")
        );
        assertEquals(sortPartitions(expected), sortPartitions(Backtracking2.partition(s)));
    }

    @Test
    void testPartition_AllSingleCharacters() {
        String s = "abc";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a", "b", "c")
        );
        assertEquals(sortPartitions(expected), sortPartitions(Backtracking2.partition(s)));
    }

    @Test
    void testPartition_MultiplePalindromes() {
        String s = "aabbaa";
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("a", "a", "a", "a", "b", "b"),
            Arrays.asList("a", "a", "aa", "b", "b"),
            Arrays.asList("a", "a", "a", "a", "bb"),
            Arrays.asList("a", "a", "aa", "bb"),
            Arrays.asList("a", "a", "aa", "b", "b"),
            Arrays.asList("aa", "aa", "b", "b"),
            Arrays.asList("a", "a", "aa", "bb"),
            Arrays.asList("aa", "aa", "bb"),
            Arrays.asList("a", "a", "abba"),
            Arrays.asList("aabbaa")
        );
        assertEquals(sortPartitions(expected), sortPartitions(Backtracking2.partition(s)));
    }

    @Test
    void testPartition_NullInput() {
        String s = null;
        assertThrows(NullPointerException.class, () -> Backtracking2.partition(s));
    }

}
