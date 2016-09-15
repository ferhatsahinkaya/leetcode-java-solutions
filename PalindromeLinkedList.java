/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null) {
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            slow = slow.next;
        }
        
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;
        second = reverse(second);
        
        while(first != null && second != null) {
            if(first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
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