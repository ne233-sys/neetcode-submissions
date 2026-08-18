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
    public void reorderList(ListNode head) {
        ListNode head2 = head, prev = null, temp = head, temp2;
        int length = 0;

        while(temp != null){
            temp = temp.next;
            length++;
        }

        if(length < 3) return;

        //moving head2 to the second half of the linked list
        for(int i = 0; i < (length + 1) / 2; i++) head2 = head2.next; 

        //reversing second half
        for(int i = 0; i < length / 2; i++){
            temp = head2.next;
            head2.next = prev;
            prev = head2;
            if(temp != null) head2 = temp;
        }

        //merging first half and reversed second half
        prev = head;
        temp = head.next;
        temp2 = head2.next;

        for(int i = 0; i < length / 2; i++){
            head2.next = temp;
            prev.next = head2;

            prev = temp;
            if(temp != null) temp = temp.next;
            head2 = temp2;
            if(temp2 != null) temp2 = temp2.next;
        }

        temp = head;
        for(int i = 0; i < length - 1; i++) temp = temp.next;
        temp.next = null;
    }
}
