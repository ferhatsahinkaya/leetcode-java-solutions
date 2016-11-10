/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        
        boolean oddNode = true;
        ListNode runner = head;
        while(runner != null) {
            ListNode runnerNext = runner.next;
            if(oddNode) {
                if(oddHead == null) {
                    oddHead = oddTail = runner;
                } else {
                    oddTail.next = runner;
                }
                oddTail = runner;
            } else {
                if(evenHead == null) {
                    evenHead = evenTail = runner;
                } else {
                    evenTail.next = runner;
                }
                evenTail = runner;
            }
            runner.next = null;
            runner = runnerNext;
            oddNode = !oddNode;
        }
        if(oddHead == null) return evenHead;
        oddTail.next = evenHead;
        return oddHead;
    }
}