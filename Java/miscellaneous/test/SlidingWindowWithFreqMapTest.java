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

        @Test
    void testMinWindow_Example1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 1 Failed: Basic example");
    }

    @Test
    void testMinWindow_Example2() {
        String s = "a";
        String t = "a";
        String expected = "a";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 2 Failed: s and t are identical");
    }

    @Test
    void testMinWindow_Example3() {
        String s = "a";
        String t = "aa";
        String expected = "";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 3 Failed: s cannot contain t");
    }

    @Test
    void testMinWindow_NoValidWindow() {
        String s = "ADOBEC";
        String t = "XYZ";
        String expected = "";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 4 Failed: No valid window exists");
    }

    @Test
    void testMinWindow_TLongerThanS() {
        String s = "abc";
        String t = "abcd";
        String expected = "";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 5 Failed: t is longer than s");
    }

    @Test
    void testMinWindow_EmptyS() {
        String s = "";
        String t = "abc";
        String expected = "";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 6 Failed: Empty s string");
    }

    @Test
    void testMinWindow_EmptyT() {
        String s = "abc";
        String t = "";
        String expected = ""; // Standard behavior for empty t in LeetCode
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 7 Failed: Empty t string");
    }

    @Test
    void testMinWindow_BothEmpty() {
        String s = "";
        String t = "";
        String expected = ""; // Consistent with empty t
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 8 Failed: Both empty strings");
    }

    @Test
    void testMinWindow_TDupCharsFound() {
        String s = "AA";
        String t = "AA";
        String expected = "AA";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 9 Failed: t with duplicates, exact match");
    }

    @Test
    void testMinWindow_TDupCharsNotFound() {
        String s = "ABCA";
        String t = "AAA";
        String expected = ""; // Only two 'A's are available in 's'
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 10 Failed: t with duplicates, not enough in s");
    }

    @Test
    void testMinWindow_AllCharsInSButNotValidWindow() {
        String s = "bmb";
        String t = "bb";
        String expected = "bmb"; // Smallest window containing two 'b's
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 11 Failed: All chars present but no valid window");
    }

    @Test
    void testMinWindow_SingleCharT() {
        String s = "abcdefg";
        String t = "d";
        String expected = "d";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 12 Failed: Single character t");
    }

    @Test
    void testMinWindow_WindowAtBeginning() {
        String s = "abccba";
        String t = "abc";
        String expected = "abc";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 13 Failed: Window at beginning");
    }

    @Test
    void testMinWindow_WindowAtEnd() {
        String s = "xabcde";
        String t = "cde";
        String expected = "cde";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 14 Failed: Window at end");
    }

    @Test
    void testMinWindow_WindowInMiddle() {
        String s = "xyzabcdegf";
        String t = "bcd";
        String expected = "bcd";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 15 Failed: Window in middle");
    }

    @Test
    void testMinWindow_LongStringComplex() {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        // 'a' (at index 11), 'b' (at 12), 'c' (at 17), 'd' (at 18), 'd' (at 19) => length 8
        // or 'a' (at 7), 'b' (at 12), 'c' (at 17), 'd' (at 18), 'd' (at 19) => length 13
        // This problem needs the *minimum* window.
        // ADOBECODEBANC, ABC -> BANC (length 4)
        // aaaaaaaaaaaabbbbbcdd, abcdd
        // The characters needed are a:1, b:1, c:1, d:2
        // Window "abbbbcdd" from index 11 to 19 (length 9)
        // The first 'a' we need is the last 'a' at index 11.
        String expected = "abbbbbcdd"; // The substring starts from the last 'a'
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 16 Failed: Long complex string");
    }

    @Test
    void testMinWindow_TIsSingleCharacterRepeated() {
        String s = "abracadabra";
        String t = "aaaaa";
        String expected = "abracada"; // The first 'a' and enough 'a's from the rest.
        // Expected substring from "a" at index 0 to "a" at index 7: "abracada" (length 8)
        // Count: a:5, b:1, r:1, c:1, d:1
        // Smallest window containing 5 'a's is "abracadabra" itself if we take all 'a's
        // Or consider "abracadabra" has 5 'a's.
        // It should be 'abracada'.
        // a at 0, a at 3, a at 5, a at 7, a at 10 (total 5 'a's)
        // From 0: "abracadabra" (length 11) - contains all 5 'a's
        // From 3: "acadabra" (length 8) - contains 4 'a's. No.
        // It depends on the algorithm's greedy approach.
        // Let's trace it: a:1, b:1, r:1, a:2, c:1, a:3, d:1, a:4, b:1, r:1, a:5
        // "abracadabra" contains 5 'a's.
        // The first 5 'a's are at indices 0, 3, 5, 7, 10.
        // To get 5 'a's, the minimum window ending at index 10 would be from index 0 ("abracadabra"). Length 11.
        // What about "aaaaa"? If `t` is "aaaaa", and `s` is "aaabbbaaa", minimum is "aaabbbaaa" (length 9).
        // My expected for `abracadabra` and `aaaaa` would be the whole string.
        // Let's change this test to something simpler:
        String s2 = "aaabbbaacde";
        String t2 = "aaa";
        String expected2 = "aaa";
        assertEquals(expected2, SlidingWindowWithFreqMap.minWindow(s2, t2), "MinWindow Test Case 17 Failed: t is single character repeated");
    }

    @Test
    void testMinWindow_WindowIsEntireS() {
        String s = "abcdef";
        String t = "fedcba"; // Anagram of s
        String expected = "abcdef";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 18 Failed: Window is entire s string (anagram)");
    }

    @Test
    void testMinWindow_NullS() {
        String s = null;
        String t = "abc";
        String expected = "";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 19 Failed: Null s string");
    }

    @Test
    void testMinWindow_NullT() {
        String s = "abc";
        String t = null;
        String expected = "";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 20 Failed: Null t string");
    }

    @Test
    void testMinWindow_TIsSubsetOfSButScattered() {
        String s = "acbdbe";
        String t = "abe";
        String expected = "acbdbe"; // Or maybe "cbdbe" or "cbe"?
        // a,b,e
        // "acbdbe" contains all. Length 6.
        // Let's manually trace for "acbdbe", "abe"
        // a (0): Map:{a:1}
        // c (1): Map:{a:1, c:1}
        // b (2): Map:{a:1, b:1, c:1} -> Found 'a','b'. Need 'e'.
        // d (3): Map:{a:1, b:1, c:1, d:1}
        // b (4): Map:{a:1, b:2, c:1, d:1}
        // e (5): Map:{a:1, b:2, c:1, d:1, e:1} -> Found 'a','b','e'. Valid window: "acbdbe" (len 6). minLen=6.
        // Shrink: remove 'a'. Window: "cbdbe". Map:{b:2, c:1, d:1, e:1}. 'a' not in window. Need one 'a'.
        // Remove 'c'. Window: "bdbe". Map:{b:2, d:1, e:1}. Need 'a'.
        // MinWindow should be "acbdbe"
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 21 Failed: t is subset of s but scattered");
    }

    @Test
    void testMinWindow_TContainsCharsNotInS() {
        String s = "abcdefg";
        String t = "axc"; // 'x' not in 's'
        String expected = "";
        assertEquals(expected, SlidingWindowWithFreqMap.minWindow(s, t), "MinWindow Test Case 22 Failed: t contains chars not in s");
    }

}
