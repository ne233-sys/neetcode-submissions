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
        int n1, n2, step = 0;
        String sum = "";
        ListNode curr1 = l1, curr2 = l2;

        while(curr1 != null || curr2 != null){
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

            if(sum.length() > step) sum = (Character.getNumericValue(sum.charAt(0)) + n1 + n2) + sum.substring(1, sum.length());
            else sum = (n1 + n2) + sum;
            step++;
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
