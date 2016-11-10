/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            slow = slow.next;
        }
        ListNode second = reverse(slow.next);
        slow.next = null;
        merge(head, second);
    }
    private void merge(ListNode l1, ListNode l2) {
        ListNode runner1 = l1;
        ListNode runner2 = l2;
        if(runner2 == null) return;
        
        ListNode tail = null;
        boolean isFirst = true;
        while(runner2 != null) {
            ListNode newNode = isFirst ? runner1 : runner2;
            if(tail != null) {
                tail.next = newNode;
            }
            tail = newNode;
            
            runner1 = isFirst ? runner1.next : runner1;
            runner2 = !isFirst ? runner2.next : runner2;
            
            tail.next = null;
            isFirst = !isFirst;
        }
        if(runner1 != null) tail.next = runner1;
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