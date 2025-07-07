package miscellaneous;



public class LinkedListProblems {

    public static class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

//Leetcode Problem https://leetcode.com/problems/reverse-linked-list/
public static ListNode reverseList(ListNode head) 
{
    if (head == null || head.next == null)
        return head;

    ListNode prev = null;
    ListNode current = head;
    ListNode next;

    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    return prev;
}

    public static void main(String[] args) {
        
    }
    
}
