package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
