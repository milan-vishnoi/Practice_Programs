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
}