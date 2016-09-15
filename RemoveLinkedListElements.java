/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode runner = head;
        ListNode prev = null;
        
        ListNode newHead = head;
        while(runner != null) {
            ListNode runnerNext = runner.next;
            if(runner.val == val) {
                if(prev == null) {
                    newHead = runnerNext;
                } else {
                    prev.next = runnerNext;
                }
                runner = runnerNext;
            } else {
                prev = runner;
                runner = runnerNext;
            }
        }
        return newHead;
    }
}