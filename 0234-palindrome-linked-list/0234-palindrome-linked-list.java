/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode findnode(ListNode Head)
    {
        ListNode slow = Head;
        ListNode fast = Head;

        while(fast !=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(ListNode Head) {
        if(Head == null || Head.next == null)
        {
            return true;
        }

        ListNode mid = findnode(Head);

        ListNode curr = mid;
        ListNode prev = null;
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev;
    ListNode left = Head;

    while(right != null)
    {
        if(left.val != right.val)
        {
            return false;
        }

        left = left.next;
        right = right.next;
    }

     return true;
    }

    
}