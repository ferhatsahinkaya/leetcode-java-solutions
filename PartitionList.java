/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode greaterHead = null;
        ListNode greaterTail = null;
        
        ListNode runner = head;
        while(runner != null) {
            ListNode runnerNext = runner.next;
            runner.next = null;
            if(runner.val < x) {
                if(lessHead == null) {
                    lessHead = runner;
                } else {
                    lessTail.next = runner;
                }
                lessTail = runner;
            } else {
                if(greaterHead == null) {
                    greaterHead = runner;
                } else {
                    greaterTail.next = runner;
                }
                greaterTail = runner;
            }
            runner = runnerNext;
        }
        if(lessTail != null) {
            lessTail.next = greaterHead;
        }
        return (lessHead == null) ? greaterHead : lessHead;
    }
}