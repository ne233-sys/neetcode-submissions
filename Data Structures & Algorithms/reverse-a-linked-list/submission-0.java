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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return head;

        ListNode tail = head;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        while(next != null){
            tail.next = next;
            curr.next = prev;

            prev = curr;
            curr = next;
            next = next.next;
        }

        tail.next = null;
        curr.next = prev;
        return curr;
    }
}
