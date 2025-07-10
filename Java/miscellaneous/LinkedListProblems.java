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

    // Leetcode Problem https://leetcode.com/problems/linked-list-cycle-ii/
    public static ListNode detectCycle(ListNode head) 
    {
        ListNode meeting=null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode result = null;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast= fast.next.next;
            if(fast==slow)
            {
                meeting = slow;
                break;
            }
        }
       if(meeting==null)
        return result;
    
       result = head;

       while(result!=meeting)
       {
         meeting= meeting.next;
        //  if(result==meeting)
        //  return result;
         result= result.next;
       }
       return result;       
    }

    // Leetcode problem https://leetcode.com/problems/merge-two-sorted-lists/
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        if(list1 == null)
        return list2;
        else if(list2 == null)
        return list1;

        ListNode result=null;
        ListNode curr;
        if(list1.val < list2.val)
        {
            result = list1;
            list1 = list1.next;
        }
        else
        {
            result = list2;
            list2 = list2.next;
        }
        curr = result;

        while(list1!=null && list2!=null)
        {
        if(list1.val < list2.val)
        {
               curr.next = list1;
               list1 = list1.next;
        }
        else
        {
            curr.next = list2;
            list2 = list2.next;
        }
           curr = curr.next;
        }

        while(list1!=null)
        {
           curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }

        while(list2!=null)
        {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }

        return result;
    }

    // Leetcode https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public static ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head.next==null)
        return null;

        ListNode slow=head;
        ListNode fast=head;
        //ListNode temp;
        for(int i=1;i<=n;i++)
        fast = fast.next;

        if(fast == null)
        return head.next;

        while(fast.next!=null)
        {
            slow=slow.next;
            fast = fast.next;
        }

        //temp = slow.next;
        slow.next = slow.next.next;
        //temp.next = null;

        return head; 
    }

    //Leetcode Problem https://leetcode.com/problems/reorder-list/
    public static void reorderList(ListNode head) 
    {

       if(head==null || head.next==null ||head.next.next==null)
        return;
        ListNode slow=head;
        ListNode fast = head;
        ListNode prev, curr, nextMid;
        ListNode temp;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        prev = slow;
        curr = slow.next;

        while(curr!=null)
        {
            nextMid = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextMid;
        }

        curr = head;

        while(slow!=prev)
        {
            temp = prev;
            prev = prev.next;
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }

        slow.next = null;

    }

    //Leetcode problem https://leetcode.com/problems/palindrome-linked-list/
    public static boolean isPalindrome(ListNode head) 
    {

        if(head==null || head.next==null)
        return true;
        else if(head.next.next==null && head.val!=head.next.val)
        return false;

        ListNode fast=head;
        ListNode slow = head;
        ListNode prev,curr,next;

        while(fast!=null && fast.next!=null &&fast.next.next!=null)
        {
            slow = slow.next;
            fast=fast.next.next;
        }

        prev = slow;
        curr = slow.next;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = head;
        while(slow!=prev)
        {
            if(curr.val!=prev.val)
            return false;

            prev = prev.next;
            curr = curr.next;
        }

        return true;
        
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
