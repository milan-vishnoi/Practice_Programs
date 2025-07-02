package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
