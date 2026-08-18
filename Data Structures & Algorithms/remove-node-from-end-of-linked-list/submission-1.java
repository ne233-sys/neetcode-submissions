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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0, target;

        ListNode temp = head, prev = null;

        while(temp != null){
            temp = temp.next;
            length++;
        }
        target = length - n;
        temp = head;

        if(length == 0) return null;
        if(target == 0) return head.next;

        for(int i = 0; i < target; i++){
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
        return head;
    }
}
