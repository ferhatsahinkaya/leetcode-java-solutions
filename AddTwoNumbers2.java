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
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        int carry = 0;
        ListNode sum = null;
        ListNode tail = null;
        while(l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            int val = val1 + val2 + carry;
            carry = val / 10;
            val %= 10;
            
            ListNode newNode = new ListNode(val);
            if(sum == null) {
                sum = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return reverse(sum);
    }
    private ListNode reverse(ListNode list) {
        ListNode prev = null;
        while(list != null) {
            ListNode next = list.next;
            list.next = prev;
            prev = list;
            list = next;
        }
        return prev;
    }
}