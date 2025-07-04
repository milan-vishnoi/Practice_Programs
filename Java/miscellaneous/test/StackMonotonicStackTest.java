package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

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

    // --- Test Cases for nextGreaterElementsCircularArray (LeetCode 503) ---

    @Test
    void testNextGreaterElementsCircularArray_Example1() {
        int[] nums = {1, 2, 1};
        int[] expected = {2, -1, 2};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_Example2() {
        int[] nums = {1, 2, 3, 4, 3};
        int[] expected = {2, 3, 4, -1, 4};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_AllSameElements() {
        int[] nums = {5, 5, 5, 5};
        int[] expected = {-1, -1, -1, -1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_SingleElement() {
        int[] nums = {10};
        int[] expected = {-1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_AscendingOrder() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4, 5, -1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_DescendingOrder() {
        int[] nums = {5, 4, 3, 2, 1};
        int[] expected = {-1, 5, 5, 5, 5};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_MixedValues() {
        int[] nums = {100, 1, 11, 1, 120, 111, 123, 1};
        int[] expected = {120, 11, 120, 120, 123, 123, -1, 100};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_WithZeros() {
        int[] nums = {0, 1, 0, 2, 0};
        int[] expected = {1, 2, 2, -1, 1};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_NegativeNumbers() {
        int[] nums = {-3, -2, -1, -5, -4};
        int[] expected = {-2, -1, -1, -4, -3};
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_LongArray() {
        int[] nums = new int[10000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = i; // 0, 1, 2, ..., 9999
        }
        int[] expected = new int[10000];
        for (int i = 0; i < 9999; i++) {
            expected[i] = i + 1;
        }
        expected[9999] = -1;
        assertArrayEquals(expected, StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_NullArray() {
        int[] nums = null;
        assertThrows(NullPointerException.class, () -> StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    @Test
    void testNextGreaterElementsCircularArray_EmptyArray() {
        int[] nums = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> StackMonotonicStack.nextGreaterElementsCircularArray(nums));
    }

    // --- Test Cases for dailyTemperatures (LeetCode 739) ---

    @Test
    void testDailyTemperatures_Example1() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, StackMonotonicStack.dailyTemperatures(temperatures));
    }

    @Test
    void testDailyTemperatures_Example2() {
        int[] temperatures = {30, 40, 50, 60};
        int[] expected = {1, 1, 1, 0};
        assertArrayEquals(expected, StackMonotonicStack.dailyTemperatures(temperatures));
    }

    @Test
    void testDailyTemperatures_Example3() {
        int[] temperatures = {30, 60, 90};
        int[] expected = {1, 1, 0};
        assertArrayEquals(expected, StackMonotonicStack.dailyTemperatures(temperatures));
    }

    @Test
    void testDailyTemperatures_DecreasingOrder() {
        int[] temperatures = {90, 80, 70, 60};
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, StackMonotonicStack.dailyTemperatures(temperatures));
    }

    @Test
    void testDailyTemperatures_AllSameTemperature() {
        int[] temperatures = {70, 70, 70, 70};
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, StackMonotonicStack.dailyTemperatures(temperatures));
    }

    @Test
    void testDailyTemperatures_SingleTemperature() {
        int[] temperatures = {70};
        int[] expected = {0};
        assertArrayEquals(expected, StackMonotonicStack.dailyTemperatures(temperatures));
    }

    @Test
    void testDailyTemperatures_WarmThenCold() {
        int[] temperatures = {80, 70, 60, 50, 90};
        int[] expected = {4, 3, 2, 1, 0};
        assertArrayEquals(expected, StackMonotonicStack.dailyTemperatures(temperatures));
    }

    @Test
    void testDailyTemperatures_MixedFluctuations() {
        int[] temperatures = {34, 80, 80, 80, 34, 80, 80, 80, 34, 80};
        int[] expected = {1, 0, 0, 0, 1, 0, 0, 0, 1, 0};
        assertArrayEquals(expected, StackMonotonicStack.dailyTemperatures(temperatures));
    }

    @Test
    void testDailyTemperatures_MaxAndMinConstraints() {
        int[] temperatures = {30, 100, 30, 100, 30};
        int[] expected = {1, 0, 1, 0, 0};
        assertArrayEquals(expected, StackMonotonicStack.dailyTemperatures(temperatures));
    }

    @Test
    void testDailyTemperatures_LongArray() {
        int[] temperatures = new int[100000];
        Arrays.fill(temperatures, 70);
        temperatures[50000] = 80;
        temperatures[99999] = 75;
        
        int[] expected = new int[100000];
        Arrays.fill(expected, 0);
        for(int i = 0; i < 50000; i++) {
            expected[i] = 50000 - i;
        }
        
        assertEquals(expected[0], StackMonotonicStack.dailyTemperatures(temperatures)[0]);
        assertEquals(expected[49999], StackMonotonicStack.dailyTemperatures(temperatures)[49999]);
        assertEquals(expected[50000], StackMonotonicStack.dailyTemperatures(temperatures)[50000]);
        assertEquals(expected[99999], StackMonotonicStack.dailyTemperatures(temperatures)[99999]);
    }

    @Test
    void testDailyTemperatures_NullArray() {
        int[] temperatures = null;
        assertThrows(NullPointerException.class, () -> StackMonotonicStack.dailyTemperatures(temperatures));
    }

    @Test
    void testDailyTemperatures_EmptyArray() {
        int[] temperatures = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> StackMonotonicStack.dailyTemperatures(temperatures));
    }
}
