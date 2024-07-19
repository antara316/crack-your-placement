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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int num =0;
        int size = 0;

        while(temp != null)
        {
            temp = temp.next;
            size++;
        }

        ListNode temp_node = head;

        for(int i = size-1;i>=0;i--)
        {
            num = num + (temp_node.val)*(int)Math.pow(2,i);
            temp_node = temp_node.next;
        }

        return num;
    }
}