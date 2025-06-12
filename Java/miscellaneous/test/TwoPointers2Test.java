package miscellaneous.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import miscellaneous.TwoPointers2;

import java.util.Arrays;

public class TwoPointers2Test {

    // Helper method to extract the relevant part of the array for comparison
    private int[] getSubArray(int[] array, int length) {
        if (array == null || length < 0 || length > array.length) {
            // Handle invalid length or null array for safety, though test cases should provide valid ones
            return new int[0];
        }
        return Arrays.copyOfRange(array, 0, length);
    }

    private void assertArrayContentEqualsRegardlessOrder(int[] actualArray, int actualLength, int[] expectedContent, String message) {
        // Handle cases where actualLength is 0 (empty result)
        if (actualLength == 0) {
            assertEquals(0, expectedContent.length, message + ": Expected empty array content.");
            return;
        }

        // Extract the relevant part of the actual array
        int[] actualSubArray = Arrays.copyOf(actualArray, actualLength);
        
        // Sort both for comparison
        Arrays.sort(actualSubArray);
        Arrays.sort(expectedContent);

        assertArrayEquals(expectedContent, actualSubArray, message + ": Array content mismatch.");
    }


    // --- Test Cases for removeDuplicates (LeetCode 80: Remove Duplicates from Sorted Array II) ---

    @Test
    void testRemoveDuplicatesII_Example1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int expectedLength = 3;
        int[] expectedNums = {1, 2, 3};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 1 Failed: Length mismatch for example 1");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 1 Failed: Array content mismatch for example 1");
    }

    @Test
    void testRemoveDuplicatesII_Example2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int expectedLength = 4;
        int[] expectedNums = {0,1, 2, 3};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 2 Failed: Length mismatch for example 2");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 2 Failed: Array content mismatch for example 2");
    }

    @Test
    void testRemoveDuplicatesII_EmptyArray() {
        int[] nums = {};
        int expectedLength = 0;
        int[] expectedNums = {};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 3 Failed: Length mismatch for empty array");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 3 Failed: Array content mismatch for empty array");
    }

    @Test
    void testRemoveDuplicatesII_SingleElement() {
        int[] nums = {5};
        int expectedLength = 1;
        int[] expectedNums = {5};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 4 Failed: Length mismatch for single element");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 4 Failed: Array content mismatch for single element");
    }

    @Test
    void testRemoveDuplicatesII_TwoElements_Unique() {
        int[] nums = {1, 2};
        int expectedLength = 2;
        int[] expectedNums = {1, 2};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 5 Failed: Length mismatch for two unique elements");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 5 Failed: Array content mismatch for two unique elements");
    }

    @Test
    void testRemoveDuplicatesII_TwoElements_Duplicate() {
        int[] nums = {3, 3};
        int expectedLength = 1;
        int[] expectedNums = {3};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 6 Failed: Length mismatch for two duplicate elements");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 6 Failed: Array content mismatch for two duplicate elements");
    }

    @Test
    void testRemoveDuplicatesII_AllUniqueElements() {
        int[] nums = {1, 2, 3, 4, 5};
        int expectedLength = 5;
        int[] expectedNums = {1, 2, 3, 4, 5};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 7 Failed: Length mismatch for all unique elements");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 7 Failed: Array content mismatch for all unique elements");
    }

    @Test
    void testRemoveDuplicatesII_AllSameElements_MoreThanTwo() {
        int[] nums = {7, 7, 7, 7, 7};
        int expectedLength = 1;
        int[] expectedNums = {7};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 8 Failed: Length mismatch for all same elements (more than two)");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 8 Failed: Array content mismatch for all same elements (more than two)");
    }

    @Test
    void testRemoveDuplicatesII_MixedDuplicates() {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5};
        int expectedLength = 5;
        int[] expectedNums = {1, 2, 3, 4, 5};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 9 Failed: Length mismatch for mixed duplicates");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 9 Failed: Array content mismatch for mixed duplicates");
    }

    @Test
    void testRemoveDuplicatesII_NegativeNumbers() {
        int[] nums = {-3, -3, -3, -1, 0, 0, 0, 0, 2, 2, 5};
        int expectedLength = 5;
        int[] expectedNums = {-3, -1, 0, 2,5};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 10 Failed: Length mismatch for negative numbers");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 10 Failed: Array content mismatch for negative numbers");
    }

    @Test
    void testRemoveDuplicatesII_LongArray() {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7, 7, 7, 8, 8, 9, 9, 9, 9};
        int expectedLength = 9;
        int[] expectedNums = {1, 2, 3, 4, 5,  6,  7,  8, 9};

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 11 Failed: Length mismatch for long array");
        assertArrayEquals(expectedNums, getSubArray(nums, actualLength), "Test Case 11 Failed: Array content mismatch for long array");
    }

    @Test
    void testRemoveDuplicatesII_NullArray() {
        int[] nums = null;
        int expectedLength = 0;

        int actualLength = TwoPointers2.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength, "Test Case 12 Failed: Length mismatch for null array");
        // No array content assertion needed as nums is null.
    }

        // --- Test Cases for moveZeroes (LeetCode 283) ---

    @Test
    void testMoveZeroes_Example1() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        
        TwoPointers2.moveZeroes(nums); // Call the method to modify in-place
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 1 Failed: Basic example");
    }

    @Test
    void testMoveZeroes_Example2() {
        int[] nums = {0};
        int[] expected = {0};
        
        TwoPointers2.moveZeroes(nums);
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 2 Failed: Single zero element");
    }

    @Test
    void testMoveZeroes_NoZeroes() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5}; // Should remain unchanged
        
        TwoPointers2.moveZeroes(nums);
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 3 Failed: No zeroes in array");
    }

    @Test
    void testMoveZeroes_AllZeroes() {
        int[] nums = {0, 0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0, 0}; // Should remain unchanged
        
        TwoPointers2.moveZeroes(nums);
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 4 Failed: All zeroes in array");
    }

    @Test
    void testMoveZeroes_SingleNonZeroElement() {
        int[] nums = {7};
        int[] expected = {7};
        
        TwoPointers2.moveZeroes(nums);
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 5 Failed: Single non-zero element");
    }

    @Test
    void testMoveZeroes_ZeroesAtBeginning() {
        int[] nums = {0, 0, 1, 2, 3};
        int[] expected = {1, 2, 3, 0, 0};
        
        TwoPointers2.moveZeroes(nums);
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 6 Failed: Zeroes at the beginning");
    }

    @Test
    void testMoveZeroes_ZeroesAtEnd() {
        int[] nums = {1, 2, 3, 0, 0};
        int[] expected = {1, 2, 3, 0, 0}; // Should remain unchanged
        
        TwoPointers2.moveZeroes(nums);
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 7 Failed: Zeroes already at the end");
    }

    @Test
    void testMoveZeroes_AlternatingZeroes() {
        int[] nums = {1, 0, 2, 0, 3, 0, 4};
        int[] expected = {1, 2, 3, 4, 0, 0, 0};
        
        TwoPointers2.moveZeroes(nums);
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 8 Failed: Alternating zeroes and non-zeroes");
    }

    @Test
    void testMoveZeroes_LargeArray() {
        int[] nums = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0, 10, 0};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        TwoPointers2.moveZeroes(nums);
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 9 Failed: Large array with many zeroes");
    }

    @Test
    void testMoveZeroes_NegativeNumbers() {
        int[] nums = {-1, 0, -2, 0, -3};
        int[] expected = {-1, -2, -3, 0, 0};
        
        TwoPointers2.moveZeroes(nums);
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 10 Failed: Array with negative numbers");
    }

    @Test
    void testMoveZeroes_EmptyArray() {
        int[] nums = {};
        int[] expected = {};
        
        TwoPointers2.moveZeroes(nums);
        
        assertArrayEquals(expected, nums, "MoveZeroes Test Case 11 Failed: Empty array");
    }

    @Test
    void testMoveZeroes_NullArray() {
        int[] nums = null;
        assertThrows(NullPointerException.class, () -> TwoPointers2.moveZeroes(nums),
                "MoveZeroes Test Case 12 Failed: Should throw NullPointerException for null array");
    }

    // --- Test Cases for removeElement (LeetCode 27) ---

    @Test
    void testRemoveElement_Example1() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int expectedLength = 2;
        int[] expectedContent = {2, 2}; // Elements that should remain

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 1 Failed: Returned length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 1 Failed");
    }

    @Test
    void testRemoveElement_Example2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int expectedLength = 5;
        int[] expectedContent = {0, 1, 3, 0, 4}; // Elements that should remain (order doesn't matter)

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 2 Failed: Returned length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 2 Failed");
    }

    @Test
    void testRemoveElement_ValNotPresent() {
        int[] nums = {1, 2, 3, 4, 5};
        int val = 6; // Value not in array
        int expectedLength = 5;
        int[] expectedContent = {1, 2, 3, 4, 5};

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 3 Failed: Val not present - length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 3 Failed: Val not present - content incorrect");
    }

    @Test
    void testRemoveElement_AllElementsAreVal() {
        int[] nums = {7, 7, 7, 7, 7};
        int val = 7;
        int expectedLength = 0;
        int[] expectedContent = {}; // No elements should remain

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 4 Failed: All elements are val - length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 4 Failed: All elements are val - content incorrect");
    }

    @Test
    void testRemoveElement_EmptyArray() {
        int[] nums = {};
        int val = 0;
        int expectedLength = 0;
        int[] expectedContent = {};

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 5 Failed: Empty array - length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 5 Failed: Empty array - content incorrect");
    }

    @Test
    void testRemoveElement_SingleElement_IsVal() {
        int[] nums = {5};
        int val = 5;
        int expectedLength = 0;
        int[] expectedContent = {};

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 6 Failed: Single element is val - length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 6 Failed: Single element is val - content incorrect");
    }

    @Test
    void testRemoveElement_SingleElement_IsNotVal() {
        int[] nums = {5};
        int val = 3;
        int expectedLength = 1;
        int[] expectedContent = {5};

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 7 Failed: Single element is not val - length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 7 Failed: Single element is not val - content incorrect");
    }

    @Test
    void testRemoveElement_ValAtBeginning() {
        int[] nums = {1, 2, 3, 4, 5};
        int val = 1;
        int expectedLength = 4;
        int[] expectedContent = {2, 3, 4, 5};

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 8 Failed: Val at beginning - length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 8 Failed: Val at beginning - content incorrect");
    }

    @Test
    void testRemoveElement_ValAtEnd() {
        int[] nums = {1, 2, 3, 4, 5};
        int val = 5;
        int expectedLength = 4;
        int[] expectedContent = {1, 2, 3, 4};

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 9 Failed: Val at end - length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 9 Failed: Val at end - content incorrect");
    }

    @Test
    void testRemoveElement_MixedElements() {
        int[] nums = {4, 2, 0, 0, 1, 0, 3, 4};
        int val = 0;
        int expectedLength = 5;
        int[] expectedContent = {4, 2, 1, 3, 4};

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 10 Failed: Mixed elements - length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 10 Failed: Mixed elements - content incorrect");
    }

    @Test
    void testRemoveElement_LongArray() {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3};
        int val = 2;
        int expectedLength = 8;
        int[] expectedContent = {1, 3, 1, 3, 1, 3, 1, 3};

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 11 Failed: Long array - length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 11 Failed: Long array - content incorrect");
    }

    @Test
    void testRemoveElement_NegativeNumbers() {
        int[] nums = {-1, -2, 0, -2, -1, 0, 5};
        int val = -2;
        int expectedLength = 5;
        int[] expectedContent = {-1, 0, -1, 0, 5};

        int actualLength = TwoPointers2.removeElement(nums, val);

        assertEquals(expectedLength, actualLength, "RemoveElement Test Case 12 Failed: Negative numbers - length incorrect");
        assertArrayContentEqualsRegardlessOrder(nums, actualLength, expectedContent, "RemoveElement Test Case 12 Failed: Negative numbers - content incorrect");
    }

    @Test
    void testRemoveElement_NullArray() {
        int[] nums = null;
        int val = 0;
        assertThrows(NullPointerException.class, () -> TwoPointers2.removeElement(nums, val),
                "RemoveElement Test Case 13 Failed: Should throw NullPointerException for null array");
    }

    // --- Test Cases for backspaceCompare (LeetCode 844) ---

    @Test
    void testBackspaceCompare_Example1() {
        String s = "ab#c";
        String t = "ad#c";
        // "ac" vs "ac" -> true
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 1 Failed: 'ab#c' vs 'ad#c'");
    }

    @Test
    void testBackspaceCompare_Example2() {
        String s = "ab##";
        String t = "c#d#";
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 2 Failed: 'ab##' vs 'c#d#'");
    }

    @Test
    void testBackspaceCompare_Example3() {
        String s = "a#c";
        String t = "b";
        assertFalse(TwoPointers2.backspaceCompare(s, t), "Test Case 3 Failed: 'a#c' vs 'b'");
    }

    @Test
    void testBackspaceCompare_EmptyStrings() {
        String s = "";
        String t = "";
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 4 Failed: Empty strings");
    }

    @Test
    void testBackspaceCompare_StringsBecomeEmpty() {
        String s = "a#";
        String t = "";
        // "" vs "" -> true
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 5 Failed: One string becomes empty");
    }

    @Test
    void testBackspaceCompare_AllBackspaces() {
        String s = "###";
        String t = "##";
        // "" vs "" -> true
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 6 Failed: All backspaces");
    }

    @Test
    void testBackspaceCompare_MoreBackspacesThanChars() {
        String s = "abc###";
        String t = "xyz####";
        // "" vs "" -> true
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 7 Failed: More backspaces than characters");
    }

    @Test
    void testBackspaceCompare_NoBackspaces() {
        String s = "abc";
        String t = "abc";
        // "abc" vs "abc" -> true
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 8 Failed: No backspaces, equal");
    }

    @Test
    void testBackspaceCompare_NoBackspaces_Unequal() {
        String s = "abc";
        String t = "ab";
        // "abc" vs "ab" -> false
        assertFalse(TwoPointers2.backspaceCompare(s, t), "Test Case 9 Failed: No backspaces, unequal");
    }

    @Test
    void testBackspaceCompare_BackspaceAtBeginning() {
        String s = "###a";
        String t = "a";
        // "a" vs "a" -> true
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 10 Failed: Backspace at beginning");
    }

    @Test
    void testBackspaceCompare_MultipleConsecutiveBackspaces() {
        String s = "a##b";
        String t = "b";
        // "b" vs "b" -> true (a -> "" -> b)
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 11 Failed: Multiple consecutive backspaces");
    }

    @Test
    void testBackspaceCompare_DifferentLengthsBeforeProcessing() {
        String s = "bxj##tw"; // "btw"
        String t = "bxo#j##tw"; // "btw"
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 12 Failed: Different lengths before processing");
    }

    @Test
    void testBackspaceCompare_ComplexCase1() {
        String s = "y#fo##f"; // "f"
        String t = "y#f#o##f"; // "f"
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 13 Failed: Complex case 1");
    }

    @Test
    void testBackspaceCompare_ComplexCase2() {
        String s = "#####abcde"; // "abcde"
        String t = "abcde"; // "abcde"
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 14 Failed: Complex case 2");
    }

    @Test
    void testBackspaceCompare_MismatchAfterBackspace() {
        String s = "abc#d"; // "abd"
        String t = "ab#e"; // "abe"
        assertFalse(TwoPointers2.backspaceCompare(s, t), "Test Case 15 Failed: Mismatch after backspace");
    }

    @Test
    void testBackspaceCompare_CaseSensitivity() {
        String s = "A#b"; // "b"
        String t = "a#b"; // "b"
        assertTrue(TwoPointers2.backspaceCompare(s, t), "Test Case 16 Failed: Case sensitivity (different first char)");
    }

    @Test
    void testBackspaceCompare_NullString_S() {
        String s = null;
        String t = "a";
        assertThrows(NullPointerException.class, () -> TwoPointers2.backspaceCompare(s, t),
                "Test Case 17 Failed: Null string s should throw NPE (or be handled)");
    }

    @Test
    void testBackspaceCompare_NullString_T() {
        String s = "a";
        String t = null;
        assertThrows(NullPointerException.class, () -> TwoPointers2.backspaceCompare(s, t),
                "Test Case 18 Failed: Null string t should throw NPE (or be handled)");
    }

    @Test
    void testBackspaceCompare_BothNullStrings() {
        String s = null;
        String t = null;
        assertThrows(NullPointerException.class, () -> TwoPointers2.backspaceCompare(s, t),
                "Test Case 19 Failed: Both null strings should throw NPE (or be handled)");
    }

    // --- Test Cases for validPalindrome (LeetCode 680) ---

    @Test
    void testValidPalindrome_Example1() {
        String s = "aba";
        // Already a palindrome, 0 deletions needed
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 1 Failed: 'aba' - Already palindrome");
    }

    @Test
    void testValidPalindrome_Example2() {
        String s = "abca";
        // Delete 'b' -> "aca" OR Delete 'c' -> "aba". Both are palindromes.
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 2 Failed: 'abca' - One deletion ('b' or 'c')");
    }

    @Test
    void testValidPalindrome_Example3() {
        String s = "abc";
        // No single deletion makes it a palindrome. e.g., "ab", "ac", "bc"
        assertFalse(TwoPointers2.validPalindrome(s), "Test Case 3 Failed: 'abc' - Cannot form palindrome");
    }

    @Test
    void testValidPalindrome_AlreadyPalindromeLong() {
        String s = "racecar";
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 4 Failed: 'racecar' - Already palindrome");
    }

    @Test
    void testValidPalindrome_NeedsOneDeletionAtBeginning() {
        String s = "cbbac"; 
        s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 5 Failed: Long complex string, should be true");
    }

    @Test
    void testValidPalindrome_NeedsOneDeletionAtEnd() {
        String s = "abac"; // Delete 'c' -> "aba"
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 6 Failed: 'abac' - One deletion at end");
    }

    @Test
    void testValidPalindrome_NeedsOneDeletionInMiddle() {
        String s = "abccba"; // Already palindrome
        s = "ebcbbe"; // Delete 'c' -> "ebbbe"
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 7 Failed: 'ebcbbe' - One deletion in middle");
    }

    @Test
    void testValidPalindrome_TwoDifferentChars() {
        String s = "abccba"; // Already palindrome
        s = "eeccccbebaeeabebccceea"; // A known tricky one, should be false
        assertFalse(TwoPointers2.validPalindrome(s), "Test Case 8 Failed: 'eeccccbebaeeabebccceea' - Cannot form palindrome");
    }

    @Test
    void testValidPalindrome_SingleChar() {
        String s = "a";
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 9 Failed: Single character string");
    }

    @Test
    void testValidPalindrome_TwoChars_Palindrome() {
        String s = "aa";
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 10 Failed: Two identical characters");
    }

    @Test
    void testValidPalindrome_TwoChars_NotPalindrome() {
        String s = "ab";
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 11 Failed: Two different characters (delete one -> one char, which is palindrome)");
    }

    @Test
    void testValidPalindrome_LongStringCannotBePalindrome() {
        String s = "abcdefghijklmnopqrstuvwxyzzyxwuvtsrqponmlkjihgfedcba"; // "abcdefghijklmnopqrstuvwxyzzyxwuvtsrqponmlkjihgfedcba"
        // This is a palindrome. Let's make it not.
        s = "abcdefghijklmnopqrstuvwxyzzyxwuvtsrqponmlkjihgfedcax"; // 'x' makes it not
        assertFalse(TwoPointers2.validPalindrome(s), "Test Case 12 Failed: Long string, cannot form palindrome");
    }

    @Test
    void testValidPalindrome_LongStringBecomesPalindrome() {
        String s = "abacaba"; // Palindrome
        s = "abacabax"; // delete 'x' -> "abacaba"
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 13 Failed: Long string, becomes palindrome by deleting last char");
    }

    @Test
    void testValidPalindrome_CaseSensitivity() {
        String s = "Aba"; // Not a palindrome if case-sensitive
        assertFalse(TwoPointers2.validPalindrome(s), "Test Case 14 Failed: 'Aba' - Case sensitivity");
    }

    @Test
    void testValidPalindrome_WithSpecialChars() {
        String s = "race a car";
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 15 Failed: 'race a car' - With spaces");

        s = "madam."; // Delete '.' -> "madam"
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 16 Failed: 'madam.' - With punctuation");
    }

    @Test
    void testValidPalindrome_NullString() {
        String s = null;
        assertThrows(NullPointerException.class, () -> TwoPointers2.validPalindrome(s),
                "Test Case 17 Failed: Null string should throw NPE");
    }

    @Test
    void testValidPalindrome_LongStringMiddleDeletion() {
        String s = "a" + "b".repeat(50000) + "c" + "b".repeat(50000) + "a"; // Length ~100000
        // Expected: a + b*50000 + c + b*50000 + a -> delete 'c' should make it a palindrome.
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 18 Failed: Very long string, middle char deletion");
    }

    @Test
    void testValidPalindrome_LongStringEdgeDeletion() {
        String s = "x" + "a".repeat(99999) + "xy"; // Delete y
        assertTrue(TwoPointers2.validPalindrome(s), "Test Case 19 Failed: Very long string, edge char deletion");
    }

    // --- Test Cases for sortedSquares (LeetCode 977) ---

    @Test
    void testSortedSquares_Example1() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] expected = {0, 1, 9, 16, 100}; // Squares: 16, 1, 0, 9, 100. Sorted: 0, 1, 9, 16, 100
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 1 Failed: Example 1");
    }

    @Test
    void testSortedSquares_Example2() {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] expected = {4, 9, 9, 49, 121}; // Squares: 49, 9, 4, 9, 121. Sorted: 4, 9, 9, 49, 121
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 2 Failed: Example 2");
    }

    @Test
    void testSortedSquares_AllPositive() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 4, 9, 16, 25};
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 3 Failed: All positive numbers");
    }

    @Test
    void testSortedSquares_AllNegative() {
        int[] nums = {-5, -4, -3, -2, -1};
        int[] expected = {1, 4, 9, 16, 25}; // Squares: 25, 16, 9, 4, 1. Sorted: 1, 4, 9, 16, 25
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 4 Failed: All negative numbers");
    }

    @Test
    void testSortedSquares_ContainsZero() {
        int[] nums = {-2, -1, 0, 1, 2};
        int[] expected = {0, 1, 1, 4, 4};
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 5 Failed: Contains zero");
    }

    @Test
    void testSortedSquares_EmptyArray() {
        int[] nums = {};
        int[] expected = {};
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 6 Failed: Empty array");
    }

    @Test
    void testSortedSquares_SingleElementPositive() {
        int[] nums = {7};
        int[] expected = {49};
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 7 Failed: Single positive element");
    }

    @Test
    void testSortedSquares_SingleElementNegative() {
        int[] nums = {-3};
        int[] expected = {9};
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 8 Failed: Single negative element");
    }

    @Test
    void testSortedSquares_SingleElementZero() {
        int[] nums = {0};
        int[] expected = {0};
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 9 Failed: Single zero element");
    }

    @Test
    void testSortedSquares_Mixed_AbsNegativeLarger() {
        int[] nums = {-10, -5, 0, 1, 2};
        int[] expected = {0, 1, 4, 25, 100}; // Squares: 100, 25, 0, 1, 4. Sorted: 0, 1, 4, 25, 100
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 10 Failed: Mixed, absolute negative larger");
    }

    @Test
    void testSortedSquares_Mixed_AbsPositiveLarger() {
        int[] nums = {-2, -1, 0, 5, 10};
        int[] expected = {0, 1, 4, 25, 100}; // Squares: 4, 1, 0, 25, 100. Sorted: 0, 1, 4, 25, 100
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 11 Failed: Mixed, absolute positive larger");
    }

    @Test
    void testSortedSquares_AllSamePositive() {
        int[] nums = {5, 5, 5, 5};
        int[] expected = {25, 25, 25, 25};
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 12 Failed: All same positive elements");
    }

    @Test
    void testSortedSquares_AllSameNegative() {
        int[] nums = {-5, -5, -5, -5};
        int[] expected = {25, 25, 25, 25};
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 13 Failed: All same negative elements");
    }

    @Test
    void testSortedSquares_LargeNumbers() {
        int[] nums = {-10000, -100, 0, 100, 10000};
        int[] expected = {0, 10000, 10000, 100000000, 100000000};
        assertArrayEquals(expected, TwoPointers2.sortedSquares(nums), "Test Case 14 Failed: Large numbers");
    }

    @Test
    void testSortedSquares_NullArray() {
        int[] nums = null;
        assertThrows(NullPointerException.class, () -> TwoPointers2.sortedSquares(nums),
                "Test Case 15 Failed: Null array should throw NPE");
    }
}
