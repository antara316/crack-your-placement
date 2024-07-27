class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)   return;

        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr = slow;
        ListNode prev = null;
        ListNode dummy;
        while(curr != null){
            dummy = curr.next;
            curr.next = prev;
            prev = curr;
            curr = dummy;
        }
        
        ListNode first = head;
        ListNode second = prev;
        ListNode temp;
        while(second.next != null){
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

    }
}