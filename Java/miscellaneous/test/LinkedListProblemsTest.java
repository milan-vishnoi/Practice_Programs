package miscellaneous.test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // Helper method to get the node at a specific index
    private ListNode getNodeAtIndex(ListNode head, int index) {
        if (head == null) return null;
        ListNode current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        return current;
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

    // --- Test Cases for detectCycle (LeetCode 142) ---

    @Test
    void testDetectCycle_Example1() {
        int[] arr = {3, 2, 0, -4};
        int pos = 1;
        ListNode head = createCycleList(arr, pos);
        ListNode expectedNode = getNodeAtIndex(head, pos);
        assertEquals(expectedNode, LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_Example2() {
        int[] arr = {1, 2};
        int pos = 0;
        ListNode head = createCycleList(arr, pos);
        ListNode expectedNode = getNodeAtIndex(head, pos);
        assertEquals(expectedNode, LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_Example3() {
        int[] arr = {1};
        int pos = -1;
        ListNode head = createCycleList(arr, pos);
        assertNull(LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_NoCycleLongList() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertNull(LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_EmptyList() {
        ListNode head = createList(new int[]{});
        assertNull(LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_SingleNodeNoCycle() {
        ListNode head = createList(new int[]{1});
        assertNull(LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_TwoNodesNoCycle() {
        ListNode head = createList(new int[]{1, 2});
        assertNull(LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_TwoNodesCycleAtHead() {
        int[] arr = {1, 2};
        int pos = 0;
        ListNode head = createCycleList(arr, pos);
        ListNode expectedNode = getNodeAtIndex(head, pos);
        assertEquals(expectedNode, LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_TwoNodesCycleAtSecondNode() {
        int[] arr = {1, 2};
        int pos = 1; // Tail (2) points to itself
        ListNode head = createCycleList(arr, pos);
        ListNode expectedNode = getNodeAtIndex(head, pos);
        assertEquals(expectedNode, LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_CycleAtHeadOfMultiNodeList() {
        int[] arr = {10, 20, 30};
        int pos = 0; // 30 -> 10
        ListNode head = createCycleList(arr, pos);
        ListNode expectedNode = getNodeAtIndex(head, pos);
        assertEquals(expectedNode, LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_CycleInMiddleOfMultiNodeList() {
        int[] arr = {1, 2, 3, 4, 5};
        int pos = 2; // 5 -> 3
        ListNode head = createCycleList(arr, pos);
        ListNode expectedNode = getNodeAtIndex(head, pos);
        assertEquals(expectedNode, LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_TailPointsToItself() {
        int[] arr = {1, 2, 3};
        int pos = 2; // 3 -> 3
        ListNode head = createCycleList(arr, pos);
        ListNode expectedNode = getNodeAtIndex(head, pos);
        assertEquals(expectedNode, LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_AllNodesInCycle() {
        int[] arr = {1, 2, 3};
        int pos = 0; // 3 -> 1
        ListNode head = createCycleList(arr, pos);
        ListNode expectedNode = getNodeAtIndex(head, pos);
        assertEquals(expectedNode, LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_LongListWithCycle() {
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = i;
        }
        int pos = 5000; // Cycle from tail to middle
        ListNode head = createCycleList(arr, pos);
        ListNode expectedNode = getNodeAtIndex(head, pos);
        assertEquals(expectedNode, LinkedListProblems.detectCycle(head));
    }

    @Test
    void testDetectCycle_LongListWithCycleAtEnd() {
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = i;
        }
        int pos = 9999; // Cycle from tail to last element
        ListNode head = createCycleList(arr, pos);
        ListNode expectedNode = getNodeAtIndex(head, pos);
        assertEquals(expectedNode, LinkedListProblems.detectCycle(head));
    }

    // --- Test Cases for mergeTwoLists (LeetCode 21) ---

    @Test
    void testMergeTwoLists_Example1() {
        ListNode list1 = createList(new int[]{1, 2, 4});
        ListNode list2 = createList(new int[]{1, 3, 4});
        int[] expected = {1, 1, 2, 3, 4, 4};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_Example2() {
        ListNode list1 = createList(new int[]{});
        ListNode list2 = createList(new int[]{});
        int[] expected = {};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_Example3() {
        ListNode list1 = createList(new int[]{});
        ListNode list2 = createList(new int[]{0});
        int[] expected = {0};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_FirstListEmpty() {
        ListNode list1 = createList(new int[]{});
        ListNode list2 = createList(new int[]{1, 2, 3});
        int[] expected = {1, 2, 3};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_SecondListEmpty() {
        ListNode list1 = createList(new int[]{1, 2, 3});
        ListNode list2 = createList(new int[]{});
        int[] expected = {1, 2, 3};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_SingleNodes() {
        ListNode list1 = createList(new int[]{5});
        ListNode list2 = createList(new int[]{1});
        int[] expected = {1, 5};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_AllFromList1Smaller() {
        ListNode list1 = createList(new int[]{1, 2, 3});
        ListNode list2 = createList(new int[]{4, 5, 6});
        int[] expected = {1, 2, 3, 4, 5, 6};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_AllFromList2Smaller() {
        ListNode list1 = createList(new int[]{4, 5, 6});
        ListNode list2 = createList(new int[]{1, 2, 3});
        int[] expected = {1, 2, 3, 4, 5, 6};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_Interleaving() {
        ListNode list1 = createList(new int[]{1, 3, 5});
        ListNode list2 = createList(new int[]{2, 4, 6});
        int[] expected = {1, 2, 3, 4, 5, 6};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_DuplicateValues() {
        ListNode list1 = createList(new int[]{1, 1, 2, 3});
        ListNode list2 = createList(new int[]{1, 3, 4, 4});
        int[] expected = {1, 1, 1, 2, 3, 3, 4, 4};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_NegativeValues() {
        ListNode list1 = createList(new int[]{-5, -3, -1});
        ListNode list2 = createList(new int[]{-4, -2, 0});
        int[] expected = {-5, -4, -3, -2, -1, 0};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_BothMaxNodes() {
        int[] arr1 = new int[50];
        int[] arr2 = new int[50];
        for (int i = 0; i < 50; i++) {
            arr1[i] = i * 2;
            arr2[i] = i * 2 + 1;
        }
        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            expected[i] = i;
        }
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_NullList1() {
        ListNode list1 = null;
        ListNode list2 = createList(new int[]{1, 2, 3});
        int[] expected = {1, 2, 3};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    @Test
    void testMergeTwoLists_NullList2() {
        ListNode list1 = createList(new int[]{1, 2, 3});
        ListNode list2 = null;
        int[] expected = {1, 2, 3};
        ListNode mergedHead = LinkedListProblems.mergeTwoLists(list1, list2);
        assertArrayEquals(expected, toArray(mergedHead));
    }

    // --- Test Cases for removeNthFromEnd (LeetCode 19) ---

    @Test
    void testRemoveNthFromEnd_Example1() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        int n = 2;
        int[] expected = {1, 2, 3, 5};
        ListNode resultHead = LinkedListProblems.removeNthFromEnd(head, n);
        assertArrayEquals(expected, toArray(resultHead));
    }

    @Test
    void testRemoveNthFromEnd_Example2() {
        ListNode head = createList(new int[]{1});
        int n = 1;
        int[] expected = {};
        ListNode resultHead = LinkedListProblems.removeNthFromEnd(head, n);
        assertArrayEquals(expected, toArray(resultHead));
    }

    @Test
    void testRemoveNthFromEnd_Example3() {
        ListNode head = createList(new int[]{1, 2});
        int n = 1;
        int[] expected = {1};
        ListNode resultHead = LinkedListProblems.removeNthFromEnd(head, n);
        assertArrayEquals(expected, toArray(resultHead));
    }

    @Test
    void testRemoveNthFromEnd_RemoveHead() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        int n = 5; // Remove 5th from end, which is 1st from beginning
        int[] expected = {2, 3, 4, 5};
        ListNode resultHead = LinkedListProblems.removeNthFromEnd(head, n);
        assertArrayEquals(expected, toArray(resultHead));
    }

    @Test
    void testRemoveNthFromEnd_RemoveTail() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        int n = 1; // Remove 1st from end, which is 5th from beginning
        int[] expected = {1, 2, 3, 4};
        ListNode resultHead = LinkedListProblems.removeNthFromEnd(head, n);
        assertArrayEquals(expected, toArray(resultHead));
    }

    @Test
    void testRemoveNthFromEnd_TwoNodesRemoveFirst() {
        ListNode head = createList(new int[]{1, 2});
        int n = 2;
        int[] expected = {2};
        ListNode resultHead = LinkedListProblems.removeNthFromEnd(head, n);
        assertArrayEquals(expected, toArray(resultHead));
    }

    @Test
    void testRemoveNthFromEnd_MiddleNode() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5, 6, 7});
        int n = 4; // Remove 4 from end (which is 4)
        int[] expected = {1, 2, 3, 5, 6, 7};
        ListNode resultHead = LinkedListProblems.removeNthFromEnd(head, n);
        assertArrayEquals(expected, toArray(resultHead));
    }

    @Test
    void testRemoveNthFromEnd_LongListRemoveMiddle() {
        int[] original = new int[30];
        for (int i = 0; i < 30; i++) {
            original[i] = i + 1;
        }
        ListNode head = createList(original);
        int n = 15; // Remove 15th from end (which is 16 from start, value 16)
        int[] expected = new int[29];
        for (int i = 0; i < 15; i++) {
            expected[i] = i + 1;
        }
        for (int i = 15; i < 29; i++) {
            expected[i] = i + 2;
        }
        ListNode resultHead = LinkedListProblems.removeNthFromEnd(head, n);
        assertArrayEquals(expected, toArray(resultHead));
    }

    @Test
    void testRemoveNthFromEnd_NullHead() {
        ListNode head = null;
        int n = 1;
        assertThrows(NullPointerException.class, () -> LinkedListProblems.removeNthFromEnd(head, n));
    }

    // --- Test Cases for reorderList (LeetCode 143) ---

    @Test
    void testReorderList_Example1() {
        ListNode head = createList(new int[]{1, 2, 3, 4});
        int[] expected = {1, 4, 2, 3};
        LinkedListProblems.reorderList(head);
        assertArrayEquals(expected, toArray(head));
    }

    @Test
    void testReorderList_Example2() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        int[] expected = {1, 5, 2, 4, 3};
        LinkedListProblems.reorderList(head);
        assertArrayEquals(expected, toArray(head));
    }

    @Test
    void testReorderList_SingleNode() {
        ListNode head = createList(new int[]{1});
        int[] expected = {1};
        LinkedListProblems.reorderList(head);
        assertArrayEquals(expected, toArray(head));
    }

    @Test
    void testReorderList_TwoNodes() {
        ListNode head = createList(new int[]{1, 2});
        int[] expected = {1, 2};
        LinkedListProblems.reorderList(head);
        assertArrayEquals(expected, toArray(head));
    }

    @Test
    void testReorderList_ThreeNodes() {
        ListNode head = createList(new int[]{1, 2, 3});
        int[] expected = {1, 3, 2};
        LinkedListProblems.reorderList(head);
        assertArrayEquals(expected, toArray(head));
    }

    @Test
    void testReorderList_SixNodes() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5, 6});
        int[] expected = {1, 6, 2, 5, 3, 4};
        LinkedListProblems.reorderList(head);
        assertArrayEquals(expected, toArray(head));
    }

    @Test
    void testReorderList_SevenNodes() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5, 6, 7});
        int[] expected = {1, 7, 2, 6, 3, 5, 4};
        LinkedListProblems.reorderList(head);
        assertArrayEquals(expected, toArray(head));
    }

    @Test
    void testReorderList_LongList() {
        int[] original = new int[50000];
        for (int i = 0; i < 50000; i++) {
            original[i] = i + 1;
        }
        ListNode head = createList(original);


        int[] expected = new int[50000];
        int left = 0;
        int right = 49999;
        int k = 0;
        while (left <= right) {
            expected[k++] = original[left++];
            if (left <= right) { 
                expected[k++] = original[right--];
            }
        }
        
        LinkedListProblems.reorderList(head);
        assertArrayEquals(expected, toArray(head));
    }

    @Test
    void testReorderList_NullHead() {
        ListNode head = null;
        assertDoesNotThrow(() -> LinkedListProblems.reorderList(head));
        assertNull(head);
    }

    // --- Test Cases for isPalindrome (LeetCode 234) ---

    @Test
    void testIsPalindrome_Example1() {
        ListNode head = createList(new int[]{1, 2, 2, 1});
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_Example2() {
        ListNode head = createList(new int[]{1, 2});
        boolean expected = false;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_SingleNode() {
        ListNode head = createList(new int[]{1});
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_EmptyList() {
        // Constraints: 1 <= number of nodes. So this scenario shouldn't happen.
        // But it's good for robustness. Usually an empty list is considered a palindrome.
        ListNode head = createList(new int[]{});
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_ThreeNodePalindrome() {
        ListNode head = createList(new int[]{1, 2, 1});
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_ThreeNodeNonPalindrome() {
        ListNode head = createList(new int[]{1, 2, 3});
        boolean expected = false;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_AllSameValues() {
        ListNode head = createList(new int[]{5, 5, 5, 5, 5});
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_TwoDifferentValues() {
        ListNode head = createList(new int[]{1, 0, 0, 1});
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_TwoDifferentValuesNonPalindrome() {
        ListNode head = createList(new int[]{1, 0});
        boolean expected = false;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_LongPalindromeEvenLength() {
        int[] arr = new int[1000];
        for (int i = 0; i < 500; i++) {
            arr[i] = i % 10;
            arr[999 - i] = i % 10;
        }
        ListNode head = createList(arr);
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_LongPalindromeOddLength() {
        int[] arr = new int[1001];
        for (int i = 0; i < 500; i++) {
            arr[i] = i % 10;
            arr[1000 - i] = i % 10;
        }
        arr[500] = 7; // Middle element
        ListNode head = createList(arr);
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_LongNonPalindrome() {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i % 10;
        }
        ListNode head = createList(arr);
        boolean expected = false;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_NullHead() {
        ListNode head = null;
        boolean expected = true;
        assertEquals(expected, LinkedListProblems.isPalindrome(head));
    }

}