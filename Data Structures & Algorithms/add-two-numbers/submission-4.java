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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1, n2, step = 0, carry = 0;
        String sum = "";
        ListNode curr1 = l1, curr2 = l2;

        while(curr1 != null || curr2 != null || carry != 0){
            if(curr1 != null){
                n1 = curr1.val;
                curr1 = curr1.next;
            }
            else n1 = 0;

            if(curr2 != null){
                n2 = curr2.val;
                curr2 = curr2.next;
            }
            else n2 = 0;

            if(n2 + n1 + carry > 9){
                sum = ((n1 + n2 + carry) % 10) + sum;
                carry = (n2 + n1 + carry) / 10;
            }
            else {
                sum = (n1 + n2 + carry) + sum;
                carry = 0;
            }
        }

        if(sum == "0") return new ListNode(0);


        ListNode curr, prev = new ListNode(-1), head = prev;

        while(sum.length() > 0){
            curr = new ListNode(Character.getNumericValue(sum.charAt(sum.length() - 1)));
            prev.next = curr;
            prev = curr;
            sum = sum.substring(0, sum.length() - 1);
        }

        head = head.next;
        return head;
    }
}
