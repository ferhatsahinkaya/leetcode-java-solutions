/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode tail = head;
        ListNode runner = head;
        while(runner != null) {
            tail = runner;
            runner = runner.next;
            length++;
        }
        if(length <= 1) return head;
        
        k %= length;
        if(k == 0) return head;
        
        k = length-k-1;
        runner = head;
        for(int i=0; i<k; i++) {
            runner = runner.next;
        }
        ListNode runnerNext = runner.next;
        runner.next = null;
        tail.next = head;
        return runnerNext;
    }
}