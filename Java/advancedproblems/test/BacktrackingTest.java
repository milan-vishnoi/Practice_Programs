package advancedproblems.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import advancedproblems.Backtracking;

public class BacktrackingTest {

    // Helper method to sort a list of lists for consistent assertion
    private List<List<Integer>> sortSubsets(List<List<Integer>> subsets) {
        for (List<Integer> subset : subsets) {
            Collections.sort(subset);
        }
        // Custom comparator to sort lists based on their string representation
        // This ensures consistent ordering of subsets themselves.
        Collections.sort(subsets, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                // Handle empty lists
                if (l1.isEmpty() && l2.isEmpty()) return 0;
                if (l1.isEmpty()) return -1;
                if (l2.isEmpty()) return 1;

                int minSize = Math.min(l1.size(), l2.size());
                for (int i = 0; i < minSize; i++) {
                    int cmp = Integer.compare(l1.get(i), l2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return Integer.compare(l1.size(), l2.size());
            }
        });
        return subsets;
    }

    // Helper method to sort a list of strings for consistent assertion
    private List<String> sortStrings(List<String> list) {
        Collections.sort(list);
        return list;
    }

    private List<List<Integer>> sortCombinations(List<List<Integer>> combinations) {
        for (List<Integer> combination : combinations) {
            Collections.sort(combination);
        }
        Collections.sort(combinations, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                int minSize = Math.min(l1.size(), l2.size());
                for (int i = 0; i < minSize; i++) {
                    int cmp = Integer.compare(l1.get(i), l2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return Integer.compare(l1.size(), l2.size());
            }
        });
        return combinations;
    }

    // --- Test Cases for subsets (LeetCode 78) ---

    @Test
    void testSubsets_Example1() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsets(nums)));
    }

    @Test
    void testSubsets_Example2() {
        int[] nums = {0};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(0)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsets(nums)));
    }

    @Test
    void testSubsets_EmptyArray() {
        int[] nums = {};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList()
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsets(nums)));
    }

    @Test
    void testSubsets_SingleElement() {
        int[] nums = {5};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(5)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsets(nums)));
    }

    @Test
    void testSubsets_TwoElements() {
        int[] nums = {1, 2};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsets(nums)));
    }

    @Test
    void testSubsets_ElementsWithNegativeNumbers() {
        int[] nums = {-1, 0, 1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(-1),
                Arrays.asList(0),
                Arrays.asList(1),
                Arrays.asList(-1, 0),
                Arrays.asList(-1, 1),
                Arrays.asList(0, 1),
                Arrays.asList(-1, 0, 1)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsets(nums)));
    }

    @Test
    void testSubsets_LargerSetOfElements() {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = Backtracking.subsets(nums);
        assertEquals(16, result.size()); 
        assertTrue(sortSubsets(result).contains(Arrays.asList()));
        assertTrue(sortSubsets(result).contains(Arrays.asList(1, 2, 3, 4)));
        assertTrue(sortSubsets(result).contains(Arrays.asList(2, 4)));
        assertTrue(sortSubsets(result).contains(Arrays.asList(1, 3)));
    }

    @Test
    void testSubsets_MaxConstraintSize() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<List<Integer>> result = Backtracking.subsets(nums);
        assertEquals(1024, result.size());
        assertTrue(sortSubsets(result).contains(Arrays.asList()));
        assertTrue(sortSubsets(result).contains(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @Test
    void testSubsets_NullInput() {
        int[] nums = null;
        assertThrows(NullPointerException.class, () -> Backtracking.subsets(nums));
    }


    // --- Test Cases for subsetsWithDup (LeetCode 90) ---

    @Test
    void testSubsetsWithDup_Example1() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(1, 2),
                Arrays.asList(1, 2, 2),
                Arrays.asList(2),
                Arrays.asList(2, 2)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsetsWithDup(nums)));
    }

    @Test
    void testSubsetsWithDup_Example2() {
        int[] nums = {0};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(0)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsetsWithDup(nums)));
    }

    @Test
    void testSubsetsWithDup_EmptyArray() {
        int[] nums = {};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList()
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsetsWithDup(nums)));
    }

    @Test
    void testSubsetsWithDup_SingleElement() {
        int[] nums = {5};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(5)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsetsWithDup(nums)));
    }

    @Test
    void testSubsetsWithDup_AllDuplicates() {
        int[] nums = {1, 1, 1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 1, 1)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsetsWithDup(nums)));
    }

    @Test
    void testSubsetsWithDup_MixedDuplicatesAndUniques() {
        int[] nums = {4, 1, 4, 4};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(1, 4),
                Arrays.asList(1, 4, 4),
                Arrays.asList(1, 4, 4, 4),
                Arrays.asList(4),
                Arrays.asList(4, 4),
                Arrays.asList(4, 4, 4)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsetsWithDup(nums)));
    }

    @Test
    void testSubsetsWithDup_ElementsWithNegativeNumbersAndZero() {
        int[] nums = {-1, 0, -1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(-1),
                Arrays.asList(-1, -1),
                Arrays.asList(-1, -1, 0),
                Arrays.asList(-1, 0),
                Arrays.asList(0)
        );
        assertEquals(sortSubsets(expected), sortSubsets(Backtracking.subsetsWithDup(nums)));
    }

    @Test
    void testSubsetsWithDup_MaxConstraintSize() {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}; 
        List<List<Integer>> result = Backtracking.subsetsWithDup(nums);
        assertNotNull(result);
        assertTrue(result.size() > 0 && result.size() < (1 << nums.length));
        assertTrue(sortSubsets(result).contains(Arrays.asList()));
        assertTrue(sortSubsets(result).contains(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)));
        assertTrue(sortSubsets(result).contains(Arrays.asList(1)));
        assertTrue(sortSubsets(result).contains(Arrays.asList(2,2)));
        assertTrue(sortSubsets(result).contains(Arrays.asList(5)));
    }

    @Test
    void testSubsetsWithDup_NullInput() {
        int[] nums = null;
        assertThrows(NullPointerException.class, () -> Backtracking.subsetsWithDup(nums));
    }

    // --- Test Cases for letterCasePermutation (LeetCode 784) ---

    @Test
    void testLetterCasePermutation_Example1() {
        String s = "a1b2";
        List<String> expected = Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.letterCasePermutation(s)));
    }

    @Test
    void testLetterCasePermutation_Example2() {
        String s = "3z4";
        List<String> expected = Arrays.asList("3z4", "3Z4");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.letterCasePermutation(s)));
    }

    @Test
    void testLetterCasePermutation_Example3() {
        String s = "12345";
        List<String> expected = Arrays.asList("12345");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.letterCasePermutation(s)));
    }

    @Test
    void testLetterCasePermutation_EmptyString() {
        String s = "";
        List<String> expected = Arrays.asList("");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.letterCasePermutation(s)));
    }

    @Test
    void testLetterCasePermutation_AllLettersLowercase() {
        String s = "abc";
        List<String> expected = Arrays.asList("abc", "abC", "aBc", "aBC", "Abc", "AbC", "ABc", "ABC");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.letterCasePermutation(s)));
    }

    @Test
    void testLetterCasePermutation_AllLettersUppercase() {
        String s = "XYZ";
        List<String> expected = Arrays.asList("xyz", "xyZ", "xYz", "xYZ", "Xyz", "XyZ", "XYz", "XYZ");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.letterCasePermutation(s)));
    }

    @Test
    void testLetterCasePermutation_MixedCaseLetters() {
        String s = "aBc";
        List<String> expected = Arrays.asList("abc", "abC", "aBc", "aBC", "Abc", "AbC", "ABc", "ABC");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.letterCasePermutation(s)));
    }

    @Test
    void testLetterCasePermutation_StringWithOnlyDigits() {
        String s = "0123";
        List<String> expected = Arrays.asList("0123");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.letterCasePermutation(s)));
    }

    @Test
    void testLetterCasePermutation_LongStringMixed() {
        String s = "h1k2e3d4"; // 4 letters, 2^4 = 16 permutations
        List<String> result = Backtracking.letterCasePermutation(s);
        assertEquals(16, result.size());
        assertTrue(result.contains("h1k2e3d4"));
        assertTrue(result.contains("H1K2E3D4"));
        assertTrue(result.contains("h1K2e3D4"));
        assertTrue(result.contains("H1k2E3d4"));
    }

    @Test
    void testLetterCasePermutation_MaxConstraintLength() {
        String s = "abcdefghij";
        List<String> result = Backtracking.letterCasePermutation(s);
        assertEquals(1024, result.size());
        assertTrue(result.contains("abcdefghij"));
        assertTrue(result.contains("ABCDEFGHIJ"));
    }

    @Test
    void testLetterCasePermutation_NullInput() {
        String s = null;
        assertThrows(NullPointerException.class, () -> Backtracking.letterCasePermutation(s));
    }

    // --- Test Cases for addOperators (LeetCode 282) ---

    @Test
    void testAddOperators_Example1() {
        String num = "123";
        int target = 6;
        List<String> expected = Arrays.asList("1*2*3", "1+2+3");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.addOperators(num, target)));
    }

    @Test
    void testAddOperators_Example2() {
        String num = "232";
        int target = 8;
        List<String> expected = Arrays.asList("2*3+2", "2+3*2");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.addOperators(num, target)));
    }

    @Test
    void testAddOperators_Example3() {
        String num = "105";
        int target = 5;
        List<String> expected = Arrays.asList("1*0+5", "10-5");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.addOperators(num, target)));
    }

    @Test
    void testAddOperators_Example4() {
        String num = "00";
        int target = 0;
        List<String> expected = Arrays.asList("0+0", "0-0", "0*0");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.addOperators(num, target)));
    }

    @Test
    void testAddOperators_Example5() {
        String num = "3456237490";
        int target = 9191;
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking.addOperators(num, target)));
    }

    @Test
    void testAddOperators_SingleDigitMatchTarget() {
        String num = "5";
        int target = 5;
        List<String> expected = Arrays.asList("5");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.addOperators(num, target)));
    }

    @Test
    void testAddOperators_SingleDigitNoMatchTarget() {
        String num = "5";
        int target = 6;
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking.addOperators(num, target)));
    }

    @Test
    void testAddOperators_LeadingZerosNotAllowed() {
        String num = "100";
        int target = 0;
        List<String> expected = Arrays.asList("1*0*0", "1*0+0", "1*0-0", "10*0");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.addOperators(num, target)));
    }

    @Test
    void testAddOperators_TargetZeroWithManyZeros() {
        String num = "000";
        int target = 0;
        List<String> expected = Arrays.asList("0*0*0", "0*0+0", "0*0-0", "0+0+0", "0+0-0", "0-0+0", "0-0-0", "0-0*0", "0+0*0");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.addOperators(num, target)));
    }

    @Test
    void testAddOperators_NoSolution() {
        String num = "123";
        int target = 100;
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking.addOperators(num, target)));
    }

    @Test
    void testAddOperators_LargeTarget() {
        String num2 = "125";
        int target2 = 7;
        List<String> expected3 = Arrays.asList("12-5","1*2+5");
        assertEquals(sortStrings(expected3), sortStrings(Backtracking.addOperators(num2, target2)));
    }

    @Test
    void testAddOperators_MaximalLengthAndTarget() {
        String num = "123456789";
        int target = 45;
        List<String> expected = Arrays.asList("1+2+3+4+5+6+7+8+9");
        List<String> actual = Backtracking.addOperators(num, target);
        assertTrue(sortStrings(actual).containsAll(expected));
    }

    @Test
    void testAddOperators_NullInput() {
        String num = null;
        int target = 0;
        assertThrows(NullPointerException.class, () -> Backtracking.addOperators(num, target));
    }

    // --- Test Cases for combinationSum (LeetCode 39) ---

    @Test
    void testCombinationSum_Example1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 3),
                Arrays.asList(7)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum(candidates, target)));
    }

    @Test
    void testCombinationSum_Example2() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum(candidates, target)));
    }

    @Test
    void testCombinationSum_SingleCandidateMatchTarget() {
        int[] candidates = {5};
        int target = 5;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(5)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum(candidates, target)));
    }

    @Test
    void testCombinationSum_SingleCandidateNoMatch() {
        int[] candidates = {5};
        int target = 6;
        List<List<Integer>> expected = Collections.emptyList();
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum(candidates, target)));
    }

    @Test
    void testCombinationSum_NoSolutionPossible() {
        int[] candidates = {8, 9};
        int target = 7;
        List<List<Integer>> expected = Collections.emptyList();
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum(candidates, target)));
    }

    @Test
    void testCombinationSum_TargetIsMultipleOfCandidate() {
        int[] candidates = {2};
        int target = 6;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 2)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum(candidates, target)));
    }

    @Test
    void testCombinationSum_CandidatesIncludeOne() {
        int[] candidates = {1, 2, 3};
        int target = 3;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1, 1),
                Arrays.asList(1, 2),
                Arrays.asList(3)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum(candidates, target)));
    }

    @Test
    void testCombinationSum_LargerInput() {
        int[] candidates = {2, 4, 6, 8};
        int target = 10;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 2, 2, 2),
                Arrays.asList(2,2,2,4),
                Arrays.asList(2, 2, 6),
                Arrays.asList(2, 4, 4),
                Arrays.asList(2,8),
                Arrays.asList(4,6)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum(candidates, target)));
    }

    @Test
    void testCombinationSum_LargeTargetAndCandidates() {
        int[] candidates = {2, 3, 5, 7};
        int target = 14;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 2, 2, 2, 2, 2),
                Arrays.asList(2, 2, 2,2, 3, 3),
                Arrays.asList(2,2,2,3,5),
                Arrays.asList(2, 2, 3, 7),
                Arrays.asList(2, 2, 5, 5),
                Arrays.asList(2, 3, 3, 3, 3),
                Arrays.asList(2, 5, 7),
                Arrays.asList(3, 3, 3, 5),
                Arrays.asList(7, 7)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum(candidates, target)));
    }

    @Test
    void testCombinationSum_NullInput() {
        int[] candidates = null;
        int target = 1;
        assertThrows(NullPointerException.class, () -> Backtracking.combinationSum(candidates, target));
    }

    // --- Test Cases for combinationSum2 (LeetCode 40) ---

    @Test
    void testCombinationSum2_Example1() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1, 6),
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 7),
                Arrays.asList(2, 6)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum2(candidates, target)));
    }

    @Test
    void testCombinationSum2_Example2() {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 2),
                Arrays.asList(5)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum2(candidates, target)));
    }

    @Test
    void testCombinationSum2_NoDuplicatesInInput() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3, 5)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum2(candidates, target)));
    }

    @Test
    void testCombinationSum2_NoSolution() {
        int[] candidates = {3, 4, 5};
        int target = 2;
        List<List<Integer>> expected = Collections.emptyList();
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum2(candidates, target)));
    }

    @Test
    void testCombinationSum2_SingleDuplicateCandidate() {
        int[] candidates = {2, 2};
        int target = 2;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum2(candidates, target)));
    }

    @Test
    void testCombinationSum2_SingleDuplicateCandidateAndTargetIsSum() {
        int[] candidates = {2, 2};
        int target = 4;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum2(candidates, target)));
    }

    @Test
    void testCombinationSum2_MultipleDuplicates() {
        int[] candidates = {1, 1, 1, 2, 2};
        int target = 3;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 1,1)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum2(candidates, target)));
    }

    @Test
    void testCombinationSum2_MaxConstraints() {
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 30;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum2(candidates, target)));
    }

    @Test
    void testCombinationSum2_LargeValues() {
        int[] candidates = {1, 1, 50, 50, 100};
        int target = 102;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1, 100),
                Arrays.asList(50, 50, 1, 1)
        );
        assertEquals(sortCombinations(expected), sortCombinations(Backtracking.combinationSum2(candidates, target)));
    }

    @Test
    void testCombinationSum2_NullInput() {
        int[] candidates = null;
        int target = 1;
        assertThrows(NullPointerException.class, () -> Backtracking.combinationSum2(candidates, target));
    }
    // --- Test Cases for generateParenthesis (LeetCode 22) ---

    @Test
    void testGenerateParenthesis_N1() {
        int n = 1;
        List<String> expected = Arrays.asList("()");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.generateParenthesis(n)));
    }

    @Test
    void testGenerateParenthesis_N2() {
        int n = 2;
        List<String> expected = Arrays.asList("(())", "()()");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.generateParenthesis(n)));
    }

    @Test
    void testGenerateParenthesis_N3() {
        int n = 3;
        List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        assertEquals(sortStrings(expected), sortStrings(Backtracking.generateParenthesis(n)));
    }

    @Test
    void testGenerateParenthesis_N4() {
        int n = 4;
        List<String> result = Backtracking.generateParenthesis(n);
        assertEquals(14, result.size());
        assertTrue(sortStrings(result).containsAll(Arrays.asList("(((())))", "()()()()")));
    }

    @Test
    void testGenerateParenthesis_MaxConstraintN8() {
        int n = 8;
        List<String> result = Backtracking.generateParenthesis(n);
        assertEquals(1430, result.size());
        assertTrue(result.contains("(((((((())))))))"));
        assertTrue(result.contains("()()()()()()()()"));
    }

    @Test
    void testGenerateParenthesis_NegativeN() {
        int n = -1;
        List<String> expected = Collections.emptyList();
        assertEquals(sortStrings(expected), sortStrings(Backtracking.generateParenthesis(n)));
    }

}