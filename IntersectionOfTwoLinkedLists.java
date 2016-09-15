/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode runner = headA;
        while(runner.next != null) {
            runner = runner.next;
        }
        runner.next = headA;
        
        ListNode slow = headB;
        ListNode fast = headB;
        do {
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            slow = slow.next;
        } while(slow != fast);
        
        if(slow != fast) {
            runner.next = null;
            return null;
        }
        
        slow = headB;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        runner.next = null;
        return slow;
    }
}