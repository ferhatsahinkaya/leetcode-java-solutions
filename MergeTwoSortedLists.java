/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        
        while(l1 != null && l2 != null) {
            ListNode newNode = (l1.val <= l2.val) ? l1 : l2;
            if(tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            if(l1.val <= l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        ListNode remaining = (l1 != null) ? l1 : l2;
        if(tail != null) {
            tail.next = remaining;
        } else {
            head = remaining;
        }
        return head;
    }
}