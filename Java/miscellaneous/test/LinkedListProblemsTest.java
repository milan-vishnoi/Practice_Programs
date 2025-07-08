package miscellaneous.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import miscellaneous.LinkedListProblems;
import miscellaneous.LinkedListProblems.ListNode;

// Assuming ListNode class is defined globally or in the same file as LinkedListProblems
// For example:
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int val) {
//         this.val = val;
//     }
// }

public class LinkedListProblemsTest {

    // Helper method to create a linked list from an array
    private ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // Use the existing ListNode(int val) constructor
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]); // Use the existing ListNode(int val) constructor
            current = current.next;
        }
        return head;
    }

    // Helper method to convert a linked list to an array for assertion
    private int[] toArray(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    // Helper method to create a linked list with a cycle
    private ListNode createCycleList(int[] arr, int pos) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        ListNode cycleNode = null; // Node where the cycle points to

        if (pos == 0) {
            cycleNode = head;
        }

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
            if (i == pos) {
                cycleNode = current;
            }
        }
        // Create the cycle: tail.next points to cycleNode
        if (cycleNode != null) {
            current.next = cycleNode;
        }
        return head;
    }


    // --- Test Cases for reverseList (LeetCode 206) ---

    @Test
    void testReverseList_Example1() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        int[] expected = {5, 4, 3, 2, 1};
        ListNode reversedHead = LinkedListProblems.reverseList(head);
        assertArrayEquals(expected, toArray(reversedHead));
    }

    @Test
    void testReverseList_Example2() {
        ListNode head = createList(new int[]{1, 2});
        int[] expected = {2, 1};
        ListNode reversedHead = LinkedListProblems.reverseList(head);
        assertArrayEquals(expected, toArray(reversedHead));
    }

    @Test
    void testReverseList_EmptyList() {
        ListNode head = createList(new int[]{});
        int[] expected = {};
        ListNode reversedHead = LinkedListProblems.reverseList(head);
        assertArrayEquals(expected, toArray(reversedHead));
    }

    @Test
    void testReverseList_SingleNodeList() {
        ListNode head = createList(new int[]{1});
        int[] expected = {1};
        ListNode reversedHead = LinkedListProblems.reverseList(head);
        assertArrayEquals(expected, toArray(reversedHead));
    }

    @Test
    void testReverseList_ThreeNodeList() {
        ListNode head = createList(new int[]{1, 2, 3});
        int[] expected = {3, 2, 1};
        ListNode reversedHead = LinkedListProblems.reverseList(head);
        assertArrayEquals(expected, toArray(reversedHead));
    }

    @Test
    void testReverseList_EvenNumberOfNodes() {
        ListNode head = createList(new int[]{10, 20, 30, 40});
        int[] expected = {40, 30, 20, 10};
        ListNode reversedHead = LinkedListProblems.reverseList(head);
        assertArrayEquals(expected, toArray(reversedHead));
    }

    @Test
    void testReverseList_NegativeValues() {
        ListNode head = createList(new int[]{-1, -2, -3});
        int[] expected = {-3, -2, -1};
        ListNode reversedHead = LinkedListProblems.reverseList(head);
        assertArrayEquals(expected, toArray(reversedHead));
    }

    @Test
    void testReverseList_MixedValues() {
        ListNode head = createList(new int[]{0, 5, -1, 10});
        int[] expected = {10, -1, 5, 0};
        ListNode reversedHead = LinkedListProblems.reverseList(head);
        assertArrayEquals(expected, toArray(reversedHead));
    }

    @Test
    void testReverseList_LongList() {
        int[] original = new int[5000];
        for (int i = 0; i < 5000; i++) {
            original[i] = i + 1;
        }
        ListNode head = createList(original);
        int[] expected = new int[5000];
        for (int i = 0; i < 5000; i++) {
            expected[i] = 5000 - i;
        }
        ListNode reversedHead = LinkedListProblems.reverseList(head);
        assertArrayEquals(expected, toArray(reversedHead));
    }

    // --- Test Cases for hasCycle (LeetCode 141) ---

    @Test
    void testHasCycle_Example1() {
        ListNode head = createCycleList(new int[]{3, 2, 0, -4}, 1);
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_Example2() {
        ListNode head = createCycleList(new int[]{1, 2}, 0);
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_Example3() {
        ListNode head = createCycleList(new int[]{1}, -1);
        boolean expected = false;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_NoCycleLongList() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        boolean expected = false;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_EmptyList() {
        ListNode head = createList(new int[]{});
        boolean expected = false;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_SingleNodeNoCycle() {
        ListNode head = createList(new int[]{1});
        boolean expected = false;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_TwoNodesNoCycle() {
        ListNode head = createList(new int[]{1, 2});
        boolean expected = false;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_TwoNodesCycle() {
        ListNode head = createCycleList(new int[]{1, 2}, 0); // 2 -> 1
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_CycleAtHead() {
        ListNode head = createCycleList(new int[]{10, 20, 30}, 0); // 30 -> 10
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_CycleInMiddle() {
        ListNode head = createCycleList(new int[]{1, 2, 3, 4, 5}, 2); // 5 -> 3
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_TailPointsToItself() {
        ListNode head = createCycleList(new int[]{1, 2, 3}, 2); // 3 -> 3
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_AllNodesInCycle() {
        ListNode head = createCycleList(new int[]{1, 2, 3}, 0); // 3 -> 1
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

    @Test
    void testHasCycle_LongListWithCycle() {
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = i;
        }
        ListNode head = createCycleList(arr, 5000); // Cycle from tail to middle
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.hasCycle(head));
    }

}