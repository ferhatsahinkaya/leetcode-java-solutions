/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode newHead = null;
        ListNode newTail = null;
        
        ListNode runner = head;
        while(runner != null) {
            int count = 0;
            ListNode node = runner;
            int value = runner.val;
            while((runner != null) && (value == runner.val)) {
                runner = runner.next;
                count++;
            }
            if(count == 1) {
                if(newHead == null) {
                    newHead = node;
                } else {
                    newTail.next = node;
                }
                newTail = node;
                newTail.next = null;
            }
        }
        return newHead;
    }
}