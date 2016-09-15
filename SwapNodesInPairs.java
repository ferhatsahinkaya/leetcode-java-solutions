/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode nextNext = next.next;
        next.next = head;
        head.next = swapPairs(nextNext);
        return next;
    }
}