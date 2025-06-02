package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import miscellaneous.SlidingWindow;

public class SlidingWindowTest {

    @Test
    void testBasicPositiveNumbers() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        assertEquals(15, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {4, 5, 6}
    }

    @Test
    void testMixedPositiveAndNegativeNumbers() {
        int[] nums = {-1, 2, 3, -4, 5, -6};
        int k = 3;
        assertEquals(4, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {2, 3, -4}
    }

    @Test
    void testAllNegativeNumbers() {
        int[] nums = {-10, -2, -5, -8, -1};
        int k = 2;
        assertEquals(-7, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {-2, -5}
        int target = 5;
        assertEquals(0, SlidingWindow.minSubArrayLen(target, nums), "Test Case 6 Failed: All negative numbers");
    }

    @Test
    void testKEqualsOne() {
        int[] nums = {1, 10, 5, 20, 3};
        int k = 1;
        assertEquals(20, SlidingWindow.maxSumKSubArray(nums, k)); // Max single element
    }

    @Test
    void testKEqualsArrayLength() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        assertEquals(15, SlidingWindow.maxSumKSubArray(nums, k)); // Sum of all elements
    }

    @Test
    void testKGreaterThanArrayLength() {
        int[] nums = {1, 2, 3};
        int k = 5;
        assertThrows(IllegalArgumentException.class, () -> SlidingWindow.maxSumKSubArray(nums, k));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int k = 3;
        assertThrows(IllegalArgumentException.class, () -> SlidingWindow.maxSumKSubArray(nums, k));
        int target = 5;
        assertEquals(0, SlidingWindow.minSubArrayLen(target, nums), "Test Case 7 Failed: Empty array");
    }

    @Test
    void testNullArray() {
        int[] nums = null;
        int k = 3;
        assertThrows(IllegalArgumentException.class, () -> SlidingWindow.maxSumKSubArray(nums, k));
    }

    @Test
    void testMaxSumAtBeginning() {
        int[] nums = {10, 20, 1, 2, 3};
        int k = 2;
        assertEquals(30, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {10, 20}
    }

    @Test
    void testMaxSumAtEnd() {
        int[] nums = {1, 2, 3, 10, 20};
        int k = 2;
        assertEquals(30, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {10, 20}
    }

    @Test
    void testMaxSumInMiddle() {
        int[] nums = {1, 2, 10, 20, 3, 4};
        int k = 2;
        assertEquals(30, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {10, 20}
    }

    @Test
    void testDuplicateMaxSums() {
        int[] nums = {1, 5, 2, 5, 1};
        int k = 2;
        assertEquals(7, SlidingWindow.maxSumKSubArray(nums, k)); // Subarray {1, 5} or {2, 5}
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {5};
        int k = 1;
        assertEquals(5, SlidingWindow.maxSumKSubArray(nums, k));
    }

    @Test
    void testKIsZero() {
        int[] nums = {1, 2, 3};
        int k = 0;
        assertThrows(IllegalArgumentException.class, () -> SlidingWindow.maxSumKSubArray(nums, k));
    }

    @Test
    void testKIsNegative() {
        int[] nums = {1, 2, 3};
        int k = -2;
        assertThrows(IllegalArgumentException.class, () -> SlidingWindow.maxSumKSubArray(nums, k));    
    }

     @Test
    void testBasicCase() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        assertEquals(2, SlidingWindow.minSubArrayLen(target, nums), "Test Case 1 Failed: Basic case");
    }

    @Test
    void testTargetGreaterThanSum() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 10;
        assertEquals(0, SlidingWindow.minSubArrayLen(target, nums), "Test Case 2 Failed: Target greater than array sum");
    }

    @Test
    void testTargetEqualsSum() {
        int[] nums = {1, 2, 3, 4};
        int target = 10;
        assertEquals(4, SlidingWindow.minSubArrayLen(target, nums), "Test Case 3 Failed: Target equals array sum");
    }

    @Test
    void testSingleElementSubarray() {
        int[] nums = {5, 1, 4, 3};
        int target = 5;
        assertEquals(1, SlidingWindow.minSubArrayLen(target, nums), "Test Case 4 Failed: Single element subarray");
    }

    @Test
    void testNoSubarrayExists() {
        int[] nums = {1, 2, 1, 1, 1};
        int target = 7;
        assertEquals(0, SlidingWindow.minSubArrayLen(target, nums), "Test Case 5 Failed: No subarray exists");
    }

    @Test
    void testLargeNumbers() {
        int[] nums = {100000, 200000, 300000};
        int target = 500000;
        assertEquals(2, SlidingWindow.minSubArrayLen(target, nums), "Test Case 9 Failed: Large numbers");
    }

    @Test
    void testSubArrayAtStart() {
        int[] nums = {7, 2, 3, 1, 2};
        int target = 7;
        assertEquals(1, SlidingWindow.minSubArrayLen(target, nums), "Test Case 11 Failed: Subarray starts at the beginning");
    }

    @Test
    void testSubArrayAtEnd() {
        int[] nums = {1, 2, 3, 4, 7};
        int target = 7;
        assertEquals(1, SlidingWindow.minSubArrayLen(target, nums), "Test Case 12 Failed: Subarray ends at the end");
    }

    // Tests for lengthOfLongestSubstring
    @Test
    void testLengthOfLongestSubstring_EmptyString() {
        assertEquals(0, SlidingWindow.lengthOfLongestSubstring(""), "Test Case LLS 1 Failed: Empty string");
    }

    @Test
    void testLengthOfLongestSubstring_AllUniqueCharacters() {
        assertEquals(5, SlidingWindow.lengthOfLongestSubstring("abcde"), "Test Case LLS 2 Failed: All unique characters");
    }

    @Test
    void testLengthOfLongestSubstring_AllSameCharacters() {
        assertEquals(1, SlidingWindow.lengthOfLongestSubstring("aaaaa"), "Test Case LLS 3 Failed: All same characters");
    }

    @Test
    void testLengthOfLongestSubstring_GeneralCase1() {
        assertEquals(3, SlidingWindow.lengthOfLongestSubstring("abcabcbb"), "Test Case LLS 4 Failed: General case 'abcabcbb'");
    }

    @Test
    void testLengthOfLongestSubstring_GeneralCase2() {
        assertEquals(1, SlidingWindow.lengthOfLongestSubstring("bbbbb"), "Test Case LLS 5 Failed: General case 'bbbbb'");
    }

    @Test
    void testLengthOfLongestSubstring_GeneralCase3() {
        assertEquals(3, SlidingWindow.lengthOfLongestSubstring("pwwkew"), "Test Case LLS 6 Failed: General case 'pwwkew'");
    }

    @Test
    void testLengthOfLongestSubstring_SingleCharacter() {
        assertEquals(1, SlidingWindow.lengthOfLongestSubstring("a"), "Test Case LLS 7 Failed: Single character");
    }

    @Test
    void testLengthOfLongestSubstring_TwoDifferentCharacters() {
        assertEquals(2, SlidingWindow.lengthOfLongestSubstring("au"), "Test Case LLS 8 Failed: Two different characters");
    }

    @Test
    void testLengthOfLongestSubstring_RepeatingCharacterUpdateStartIndex() {
        assertEquals(2, SlidingWindow.lengthOfLongestSubstring("abba"), "Test Case LLS 9 Failed: Repeating char updates start index 'abba'");
    }

    @Test
    void testLengthOfLongestSubstring_LongestAtEnd() {
        assertEquals(3, SlidingWindow.lengthOfLongestSubstring("dvdf"), "Test Case LLS 10 Failed: Longest substring at the end 'dvdf'");
    }

    @Test
    void testLengthOfLongestSubstring_WithSpaces() {
        assertEquals(3, SlidingWindow.lengthOfLongestSubstring(" a b "), "Test Case LLS 11 Failed: String with spaces ' a b '");
    }

    @Test
    void testLengthOfLongestSubstring_ComplexCase() {
        assertEquals(7, SlidingWindow.lengthOfLongestSubstring("abcadcbaefg"), "Test Case LLS 12 Failed: Complex string 'abcadcbaefg'");
    }

    @Test
    void testLengthOfLongestSubstring_NoRepeat() {
        assertEquals(7, SlidingWindow.lengthOfLongestSubstring("abcdefg"), "Test Case LLS 13 Failed: No repeating characters");
    }
     @Test
    void testLengthOfLongestSubstring_SubstringAtStart() {
        assertEquals(3, SlidingWindow.lengthOfLongestSubstring("abccde"), "Test Case LLS 14 Failed: Longest substring at start 'abccde'");
    }

    @Test
    void testExample1() {
        String s = "eceba";
        int k = 2;
        assertEquals(3, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 1 Failed: eceba, k=2 should be 3 (ece)");
    }

    @Test
    void testExample2() {
        String s = "aa";
        int k = 1;
        assertEquals(2, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 2 Failed: aa, k=1 should be 2 (aa)");
    }

    @Test
    void testLenIsZero() {
        String s = "abcabcabc";
        int k = 0;
        assertEquals(0, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 3 Failed: k=0 should always return 0");
    }

    @Test
    void testEmptyString() {
        String s = "";
        int k = 2;
        assertEquals(0, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 4 Failed: Empty string should return 0");
    }

    @Test
    void testNullString() {
        String s = null;
        int k = 2;
        assertEquals(0, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 5 Failed: Null string should return 0");
    }

    @Test
    void testLenEqualsOne() {
        String s = "abaccc";
        int k = 1;
        assertEquals(3, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 6 Failed: k=1, abaccc should be 3 (ccc)");
    }

    @Test
    void testKGreaterThanDistinctChars() {
        String s = "abc";
        int k = 5; 
        assertEquals(3, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 7 Failed: k > distinct chars, should return full string length");
    }

    @Test
    void testAllCharsSame() {
        String s = "aaaaa";
        int k = 1;
        assertEquals(5, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 8 Failed: All same chars, k=1 should return full length");
    }

    @Test
    void testLongestAtBeginning() {
        String s = "abcdeffg";
        int k = 3;
        assertEquals(4, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 9 Failed: Longest at beginning/middle. For 'abcdeffg' and k=3, longest is 4 (e.g., 'deff')"
        );
    }


    @Test
    void testLongestAtEnd() {
        String s = "abccbadef";
        int k = 2;
        assertEquals(4, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k), // "ccba" or "cbab" or "bade" (4 distinct a,b,d,e)
                                                                       // "abcc" (a,b,c) len 4
                                                                       // "bccb" (b,c) len 4
                                                                       // "ccba" (c,b,a) len 4
                                                                       // "cbab" (c,b,a) len 4
                                                                       // "bade" (b,a,d,e) 4 distinct, k=2, so this window shrinks.
                                                                       // Expected longest is 4 (e.g. "bccb")
                "Test Case 10 Failed: Longest at end. For 'abccbadef' and k=2, longest is 4 (e.g., 'bccb')"
        );
    }

    @Test
    void testAlternatingChars() {
        String s = "abababa";
        int k = 2;
        assertEquals(7, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 11 Failed: Alternating chars, k=2 should be full length");
    }

    @Test
    void testLargeString() {
        String s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"; // 52 chars, 26 distinct
        int k = 26;
        assertEquals(52, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 12 Failed: Large string with k covering all distinct chars");
    }

    @Test
    void testLargeStringWithSmallK() {
        String s = "abcdeffghijkllmnoppqrstuvwxxyzaabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz";
        int k = 3;
        assertEquals(6, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 13 Failed: Large string with small k"
        );
    }

    @Test
    void testExactDistinctMatch() {
        String s = "abacaba";
        int k = 3; // Distinct: a, b, c
        assertEquals(7, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 14 Failed: Exact distinct match, should be full length");
    }

    @Test
    void testMixedDistinctChars() {
        String s = "worldisgreat";
        int k = 4;
        assertEquals(4, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 15 Failed: Mixed distinct characters");
    }

    @Test
    void testSingleCharacterString() {
        String s = "a";
        int k = 1;
        assertEquals(1, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 16 Failed: Single character string, k=1");
    }

    @Test
    void testSingleCharacterString_kGreaterThan1() {
        String s = "a";
        int k = 5;
        assertEquals(1, SlidingWindow.lengthOfLongestSubstringKDistinct(s, k),
                "Test Case 17 Failed: Single character string, k > 1");
}

}