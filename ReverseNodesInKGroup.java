/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) return head;
        
        ListNode newHead = head;
        ListNode tail = null;
        
        ListNode runner = head;
        while(runner != null) {
            ListNode subHead = runner;
            ListNode prev = null;
            int i = 0;
            while((i < k) && (runner != null)) {
                prev = runner;
                runner = runner.next;
                i++;
            }
            if(prev != null) {
                prev.next = null;
            }
            
            if(i == k) {
                ListNode reverseHead = reverse(subHead);
                if(tail != null) {
                    tail.next = reverseHead;
                } else {
                    newHead = reverseHead;
                }
                tail = subHead;
            } else {
                if(tail != null) {
                    tail.next = subHead;
                }
            }
        }
        return newHead;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode headNext = head.next;
            head.next = prev;
            prev = head;
            head = headNext;
        }
        return prev;
    }
}