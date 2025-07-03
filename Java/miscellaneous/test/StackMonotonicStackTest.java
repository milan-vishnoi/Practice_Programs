package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import miscellaneous.StackMonotonicStack;

public class StackMonotonicStackTest {

    // --- Test Cases for isValid (LeetCode 20) ---

    @Test
    void testIsValid_Example1() {
        String s = "()";
        boolean expected = true;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_Example2() {
        String s = "()[]{}";
        boolean expected = true;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_Example3() {
        String s = "(]";
        boolean expected = false;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_MismatchOrder() {
        String s = "([)]";
        boolean expected = false;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_NestedValid() {
        String s = "{[]}";
        boolean expected = true;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_UnclosedBracket() {
        String s = "([";
        boolean expected = false;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_UnopenedBracket() {
        String s = ")}";
        boolean expected = false;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_EmptyString() {
        String s = "";
        boolean expected = true;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_LongValidString() {
        String s = "((([]){()}[]{}))";
        boolean expected = true;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_LongInvalidString() {
        String s = "(((((((((()))))))))))}";
        boolean expected = false;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_OnlyOpenBrackets() {
        String s = "((({[[[";
        boolean expected = false;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_OnlyCloseBrackets() {
        String s = ")))}}]]";
        boolean expected = false;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_InvalidMiddle() {
        String s = "({[})]";
        boolean expected = false;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_AnotherMismatch() {
        String s = "{[}]";
        boolean expected = false;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    @Test
    void testIsValid_MixedValidAndInvalid() {
        String s = "([)]()";
        boolean expected = false;
        assertEquals(expected, StackMonotonicStack.isValid(s));
    }

    // --- Test Cases for nextGreaterElement (LeetCode 496) ---

    @Test
    void testNextGreaterElement_Example1() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] expected = {-1, 3, -1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_Example2() {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] expected = {3, -1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_SingleElementInNums1() {
        int[] nums1 = {4};
        int[] nums2 = {1, 3, 4, 2};
        int[] expected = {-1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_SingleElementInNums2() {
        int[] nums1 = {5};
        int[] nums2 = {5};
        int[] expected = {-1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_Nums2Increasing() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_Nums2Decreasing() {
        int[] nums1 = {5, 4, 3};
        int[] nums2 = {5, 4, 3, 2, 1};
        int[] expected = {-1, -1, -1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_Nums1HasAllElementsOfNums2() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] expected = {2, 3, 4, -1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_ComplexScenario() {
        int[] nums1 = {6, 8, 0, 7};
        int[] nums2 = {6, 8, 0, 1, 3, 7, 2, 4};
        int[] expected = {8, -1, 1, -1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_LargeValues() {
        int[] nums1 = {9999, 10000};
        int[] nums2 = {1, 5000, 9999, 10000, 2000};
        int[] expected = {10000, -1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_NullNums1() {
        int[] nums1 = null;
        int[] nums2 = {1, 2, 3};
        assertThrows(NullPointerException.class, () -> StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_NullNums2() {
        int[] nums1 = {1};
        int[] nums2 = null;
        assertThrows(NullPointerException.class, () -> StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_EmptyNums1() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        int[] expected = {};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNextGreaterElement_EmptyNums2() {
        int[] nums1 = {1}; 
        int[] nums2 = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> StackMonotonicStack.nextGreaterElement(nums1, nums2));
    }
}
