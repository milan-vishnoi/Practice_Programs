package advancedproblems.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import advancedproblems.Backtracking;
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

    // --- Test Cases for restoreIpAddresses (LeetCode 93) ---

    @Test
    void testRestoreIpAddresses_Example1() {
        String s = "25525511135";
        List<String> expected = Arrays.asList("255.255.11.135", "255.255.111.35");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.restoreIpAddresses(s)));
    }

    @Test
    void testRestoreIpAddresses_Example2() {
        String s = "0000";
        List<String> expected = Arrays.asList("0.0.0.0");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.restoreIpAddresses(s)));
    }

    @Test
    void testRestoreIpAddresses_Example3() {
        String s = "101023";
        List<String> expected = Arrays.asList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.restoreIpAddresses(s)));
    }

    @Test
    void testRestoreIpAddresses_NoValidAddresses() {
        String s = "256256256256";
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.restoreIpAddresses(s)));
    }

    @Test
    void testRestoreIpAddresses_LeadingZeros() {
        String s = "010010";
        List<String> expected = Arrays.asList("0.10.0.10", "0.100.1.0");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.restoreIpAddresses(s)));
    }

    @Test
    void testRestoreIpAddresses_MinLength() {
        String s = "1234";
        List<String> expected = Arrays.asList("1.2.3.4");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.restoreIpAddresses(s)));
    }

    @Test
    void testRestoreIpAddresses_MaxLength() {
        String s = "111111111111";
        List<String> result = Backtracking2.restoreIpAddresses(s);
        assertEquals(1, result.size());
    }

    @Test
    void testRestoreIpAddresses_AllNines() {
        String s = "999999999999";
        List<String> expected = Arrays.asList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.restoreIpAddresses(s)));
    }

    @Test
    void testRestoreIpAddresses_InvalidLengthTooShort() {
        String s = "123";
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.restoreIpAddresses(s)));
    }

    @Test
    void testRestoreIpAddresses_InvalidLengthTooLong() {
        String s = "123456789101112";
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.restoreIpAddresses(s)));
    }

    @Test
    void testRestoreIpAddresses_NullInput() {
        String s = null;
        assertThrows(NullPointerException.class, () -> Backtracking2.restoreIpAddresses(s));
    }

    // --- Test Cases for solveNQueens (LeetCode 51) ---

    @Test
    void testSolveNQueens_N1() {
        int n = 1;
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("Q")
        );
        assertEquals(expected, Backtracking2.solveNQueens(n));
    }

    @Test
    void testSolveNQueens_N4() {
        int n = 4;
        List<List<String>> expected = Arrays.asList(
                Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
                Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );
        assertEquals(expected, Backtracking2.solveNQueens(n));
    }

    @Test
    void testSolveNQueens_N2() {
        int n = 2;
        List<List<String>> expected = Collections.emptyList();
        assertEquals(expected, Backtracking2.solveNQueens(n));
    }

    @Test
    void testSolveNQueens_N3() {
        int n = 3;
        List<List<String>> expected = Collections.emptyList();
        assertEquals(expected, Backtracking2.solveNQueens(n));
    }

    @Test
    void testSolveNQueens_N8() {
        int n = 8;
        List<List<String>> result = Backtracking2.solveNQueens(n);
        assertEquals(92, result.size());
    }

    @Test
    void testSolveNQueens_N5() {
        int n = 5;
        List<List<String>> result = Backtracking2.solveNQueens(n);
        assertEquals(10, result.size());
    }

    @Test
    void testSolveNQueens_N6() {
        int n = 6;
        List<List<String>> result = Backtracking2.solveNQueens(n);
        assertEquals(4, result.size());
    }

    @Test
    void testSolveNQueens_N7() {
        int n = 7;
        List<List<String>> result = Backtracking2.solveNQueens(n);
        assertEquals(40, result.size());
    }

    @Test
    void testSolveNQueens_N9() {
        int n = 9;
        List<List<String>> result = Backtracking2.solveNQueens(n);
        assertEquals(352, result.size());
    }

    // --- Test Cases for addOperators (LeetCode 282) ---

    @Test
    void testAddOperators_Example1() {
        String num = "123";
        int target = 6;
        List<String> expected = Arrays.asList("1*2*3", "1+2+3");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.addOperators(num, target)));
    }

    @Test
    void testAddOperators_Example2() {
        String num = "232";
        int target = 8;
        List<String> expected = Arrays.asList("2*3+2", "2+3*2");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.addOperators(num, target)));
    }

    @Test
    void testAddOperators_Example3() {
        String num = "105";
        int target = 5;
        List<String> expected = Arrays.asList("1*0+5", "10-5");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.addOperators(num, target)));
    }

    @Test
    void testAddOperators_Example4() {
        String num = "00";
        int target = 0;
        List<String> expected = Arrays.asList("0+0", "0-0", "0*0");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.addOperators(num, target)));
    }

    @Test
    void testAddOperators_Example5() {
        String num = "3456237490";
        int target = 9191;
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.addOperators(num, target)));
    }

    @Test
    void testAddOperators_SingleDigitMatchTarget() {
        String num = "5";
        int target = 5;
        List<String> expected = Arrays.asList("5");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.addOperators(num, target)));
    }

    @Test
    void testAddOperators_SingleDigitNoMatchTarget() {
        String num = "5";
        int target = 6;
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.addOperators(num, target)));
    }

    @Test
    void testAddOperators_LeadingZerosNotAllowed() {
        String num = "100";
        int target = 0;
        List<String> expected = Arrays.asList("1*0*0", "1*0+0", "1*0-0", "10*0");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.addOperators(num, target)));
    }

    @Test
    void testAddOperators_TargetZeroWithManyZeros() {
        String num = "000";
        int target = 0;
        List<String> expected = Arrays.asList("0*0*0", "0*0+0", "0*0-0", "0+0+0", "0+0-0", "0-0+0", "0-0-0", "0-0*0", "0+0*0");
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.addOperators(num, target)));
    }

    @Test
    void testAddOperators_NoSolution() {
        String num = "123";
        int target = 100;
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking2.addOperators(num, target)));
    }

    @Test
    void testAddOperators_LargeTarget() {
        String num2 = "125";
        int target2 = 7;
        List<String> expected3 = Arrays.asList("12-5","1*2+5");
        assertEquals(sortStrings(expected3), sortStrings(Backtracking2.addOperators(num2, target2)));
    }

    @Test
    void testAddOperators_MaximalLengthAndTarget() {
        String num = "123456789";
        int target = 45;
        List<String> expected = Arrays.asList("1+2+3+4+5+6+7+8+9");
        List<String> actual = Backtracking2.addOperators(num, target);
        assertTrue(sortStrings(actual).containsAll(expected));
    }

    @Test
    void testAddOperators_NullInput() {
        String num = null;
        int target = 0;
        assertThrows(NullPointerException.class, () -> Backtracking2.addOperators(num, target));
    }

}
