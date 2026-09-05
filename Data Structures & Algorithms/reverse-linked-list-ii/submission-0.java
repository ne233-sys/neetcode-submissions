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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(), lNode = dummy, rNode, curr, temp;
        lNode.next = head;

        int i = 1;
        while(i < left){
            lNode = lNode.next;
            i++;
        }

        rNode = lNode.next;
        for(int j = i; j < right; j++) rNode = rNode.next;
        curr = lNode.next;
        temp = curr.next;
        lNode.next = rNode;
        rNode = rNode.next;
        
        
        while(i < right + 1){
            temp = curr.next;
            curr.next = rNode;
            rNode = curr;
            curr = temp;
            i++;
        }

        return dummy.next;
    }
}