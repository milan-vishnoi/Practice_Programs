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
}