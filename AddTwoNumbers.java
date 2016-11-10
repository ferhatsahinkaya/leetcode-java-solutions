/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode runner1 = l1;
        ListNode runner2 = l2;
        
        ListNode sumHead = null;
        ListNode sumTail = null;
        
        int carry = 0;
        while((runner1 != null) || (runner2 != null) || (carry > 0)) {
            int val1 = (runner1 != null) ? runner1.val : 0;
            int val2 = (runner2 != null) ? runner2.val : 0;
            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            
            ListNode newNode = new ListNode(digit);
            if(sumHead == null) {
                sumHead = newNode;
            } else {
                sumTail.next = newNode;
            }
            sumTail = newNode;
            
            runner1 = (runner1 != null) ? runner1.next : null;
            runner2 = (runner2 != null) ? runner2.next : null;
        }
        return sumHead;
    }
}