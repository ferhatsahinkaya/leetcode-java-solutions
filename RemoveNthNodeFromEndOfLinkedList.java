/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        
        ListNode runner = head;
        for(int i=0; i<n; i++) {
            runner = runner.next;
        }
        if(runner == null) return head.next;
        
        ListNode back = head;
        while(runner.next != null) {
            runner = runner.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
    }
}