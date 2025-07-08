package miscellaneous;



public class LinkedListProblems {

    public static class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public static void printList(ListNode head){

        ListNode current = head;
        while(current!=null)
        {
          System.out.print(current.val);
          if(current.next!=null)
          System.out.print("->");
          current = current.next;
        }

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
        head = prev;

        return prev;
    }

    // Leetcode problem https://leetcode.com/problems/linked-list-cycle/
    public static boolean hasCycle(ListNode head) 
    {

        if(head==null || head.next==null)
        return false;
        ListNode slow=head;
        ListNode fast = head;

        while(fast!=null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50};
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]); 
            current = current.next;
        }
        System.out.print("Passed List:");
        ListNode.printList(head);
        head = reverseList(head);
        System.out.print("\nReversed List:");
        ListNode.printList(head);
    }
    
}
