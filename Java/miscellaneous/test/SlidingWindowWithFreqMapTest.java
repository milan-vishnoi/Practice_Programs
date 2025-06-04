package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import miscellaneous.SlidingWindowWithFreqMap;  



public class SlidingWindowWithFreqMapTest {

    @Test
    void testExample1() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> expected = Arrays.asList(0, 6);
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 1 Failed: Basic example");
    }

    @Test
    void testExample2() {
        String s = "abab";
        String p = "ab";
        List<Integer> expected = Arrays.asList(0, 1, 2);
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 2 Failed: Overlapping anagrams");
    }

    @Test
    void testNoAnagrams() {
        String s = "abcdefg";
        String p = "xyz";
        List<Integer> expected = Arrays.asList(); // Empty list
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 3 Failed: No anagrams found");
    }

    @Test
    void testP_LongerThanS() {
        String s = "abc";
        String p = "abcd";
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 4 Failed: p is longer than s");
    }

    @Test
    void testEmptyP() {
        String s = "abc";
        String p = "";
        List<Integer> expected = Arrays.asList(); // Based on common LeetCode problem constraints for empty 'p'
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 5 Failed: Empty p string");
    }

    @Test
    void testEmptyS() {
        String s = "";
        String p = "abc";
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 6 Failed: Empty s string");
    }

    @Test
    void testBothEmpty() {
        String s = "";
        String p = "";
        List<Integer> expected = Arrays.asList(); // Consistent with handling of empty 'p'
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 7 Failed: Both empty strings");
    }

    @Test
    void testSContainsExactAnagramOnce() {
        String s = "bac";
        String p = "abc";
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 8 Failed: Exact anagram once");
    }

    @Test
    void testSWithDuplicateCharsInP() {
        String s = "aaaaa";
        String p = "aa";
        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 9 Failed: Duplicate characters in p");
    }

    @Test
    void testSWithDuplicateCharsNotMatchingP() {
        String s = "aabbc";
        String p = "abc";
        List<Integer> expected = Arrays.asList(); // Only "bc" from "aabbc"
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 10 Failed: Duplicates not matching p");
    }

    @Test
    void testLongerStringWithNoAnagrams() {
        String s = "abcdefghijklmnopqrstuvwxyzbaabcdefghijklmnopqrstuvwxyzba";
        String p = "az";
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 11 Failed: Long string no anagrams");
    }

    @Test
    void testLongStringWithAnagramsScattered() {
        String s = "bcaefgdabchijklmnopqrstuvwxyabac";
        String p = "abc";
        List<Integer> expected = Arrays.asList(0, 7, 29); // "bca" at 0, "abc" at 7, "bac" at 27
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 12 Failed: Long string with scattered anagrams");
    }

    @Test
    void testAnagramsAtBeginningAndEnd() {
        String s = "bacdefghijcba";
        String p = "bac";
        List<Integer> expected = Arrays.asList(0, 10);
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 13 Failed: Anagram at beginning and end");
    }

    @Test
    void testAllCharactersSameInP() {
        String s = "bbbbbbbbbb";
        String p = "bbb";
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 14 Failed: All same chars in p");
    }

    @Test
    void testSAndPAreIdentical() {
        String s = "abc";
        String p = "abc";
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 15 Failed: s and p are identical");
    }

    @Test
    void testSAndPAreAnagrams() {
        String s = "bca";
        String p = "abc";
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 16 Failed: s and p are anagrams");
    }

    @Test
    void testNullS() {
        String s = null;
        String p = "abc";
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 17 Failed: Null s string");
    }

    @Test
    void testNullP() {
        String s = "abc";
        String p = null;
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, SlidingWindowWithFreqMap.findAnagrams(s, p), "Test Case 18 Failed: Null p string");
    }

       // --- Tests for checkInclusion (LeetCode 567) ---

    @Test
    void testCheckInclusion_Example1() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        assertTrue(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 1 Failed: Example 1 - 'ab' in 'eidbaooo'"); // "ba" is permutation
    }

    @Test
    void testCheckInclusion_Example2() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 2 Failed: Example 2 - 'ab' not in 'eidboaoo'");
    }

    @Test
    void testCheckInclusion_ExactMatch() {
        String s1 = "abc";
        String s2 = "bac";
        assertTrue(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 3 Failed: s1 is an exact permutation of s2");
    }

    @Test
    void testCheckInclusion_S1LongerThanS2() {
        String s1 = "abc";
        String s2 = "ab";
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 4 Failed: s1 is longer than s2");
    }

    @Test
    void testCheckInclusion_EmptyS1() {
        String s1 = "";
        String s2 = "abc";
        assertTrue(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 5 Failed: Empty s1 string"); // Usually true based on LeetCode rules
    }

    @Test
    void testCheckInclusion_EmptyS2() {
        String s1 = "abc";
        String s2 = "";
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 6 Failed: Empty s2 string");
    }

    @Test
    void testCheckInclusion_BothEmpty() {
        String s1 = "";
        String s2 = "";
        assertTrue(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 7 Failed: Both empty strings"); // Consistent with empty s1
    }

    @Test
    void testCheckInclusion_S1WithDuplicatesFound() {
        String s1 = "aab";
        String s2 = "eidbaooaab";
        assertTrue(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 8 Failed: s1 with duplicates found"); // "aab" or "baa"
    }

    @Test
    void testCheckInclusion_S1WithDuplicatesNotFound() {
        String s1 = "aab";
        String s2 = "eidboaoabb"; // Needs two 'a's and one 'b'
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 9 Failed: s1 with duplicates not found");
    }

    @Test
    void testCheckInclusion_NoMatchAtAll() {
        String s1 = "abc";
        String s2 = "defg";
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 10 Failed: No common characters");
    }

    @Test
    void testCheckInclusion_MatchAtBeginning() {
        String s1 = "xyz";
        String s2 = "yzxabc";
        assertTrue(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 11 Failed: Match at beginning");
    }

    @Test
    void testCheckInclusion_MatchAtEnd() {
        String s1 = "xyz";
        String s2 = "abcdefzyx";
        assertTrue(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 12 Failed: Match at end");
    }

    @Test
    void testCheckInclusion_LongerStrings() {
        String s1 = "hello";
        String s2 = "ooolleoooleh"; // "eholl" is permutation
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 13 Failed: Longer strings, found");
    }

    @Test
    void testCheckInclusion_LongerStringsNoMatch() {
        String s1 = "programming";
        String s2 = "applebananaorange";
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 14 Failed: Longer strings, not found");
    }

    @Test
    void testCheckInclusion_SingleCharacterS1Found() {
        String s1 = "a";
        String s2 = "bca";
        assertTrue(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 15 Failed: Single char s1 found");
    }

    @Test
    void testCheckInclusion_SingleCharacterS1NotFound() {
        String s1 = "z";
        String s2 = "abc";
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 16 Failed: Single char s1 not found");
    }

    @Test
    void testCheckInclusion_S1AndS2AreIdentical() {
        String s1 = "abcde";
        String s2 = "abcde";
        assertTrue(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 17 Failed: s1 and s2 are identical");
    }

    @Test
    void testCheckInclusion_NullS1() {
        String s1 = null;
        String s2 = "abc";
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 18 Failed: Null s1 string");
    }

    @Test
    void testCheckInclusion_NullS2() {
        String s1 = "abc";
        String s2 = null;
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 19 Failed: Null s2 string");
    }

    @Test
    void testCheckInclusion_CompletelyDifferentCharacters() {
        String s1 = "xyz";
        String s2 = "abc";
        assertFalse(SlidingWindowWithFreqMap.checkInclusion(s1, s2), "CheckInclusion Test Case 20 Failed: Completely different characters");
    }
}
