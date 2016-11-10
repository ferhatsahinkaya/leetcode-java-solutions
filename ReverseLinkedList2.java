/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        if(m >= n) return head;
        
        ListNode reverseStart = head;
        ListNode reverseEnd = head;
        
        m--;
        n--;
        
        ListNode prev = null;
        while(m > 0) {
            prev = reverseStart;
            reverseStart = reverseStart.next;
            reverseEnd = reverseEnd.next;
            m--;
            n--;
        }
        while(n > 0) {
            reverseEnd = reverseEnd.next;
            n--;
        }
        ListNode remaining = reverseEnd.next;
        reverseEnd.next = null;
        reverse(reverseStart);
        if(prev != null) {
            prev.next = reverseEnd;
        } else {
            head = reverseEnd;
        }
        reverseStart.next = remaining;
        return head;
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