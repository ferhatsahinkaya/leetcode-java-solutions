/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        
        return merge(sortList(head), sortList(second));
    }
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode mergedHead = null;
        ListNode mergedTail = null;
        
        ListNode runner1 = head1;
        ListNode runner2 = head2;
        while((runner1 != null) && (runner2 != null)) {
            ListNode node = (runner1.val <= runner2.val) ? runner1 : runner2;
            if(mergedHead == null) {
                mergedHead = node;
            } else {
                mergedTail.next = node;
            }
            if(runner1.val <= runner2.val) {
                runner1 = runner1.next;
            } else {
                runner2 = runner2.next;
            }
            mergedTail = node;
            mergedTail.next = null;
        }
        if(runner1 != null) {
            if(mergedTail != null) {
                mergedTail.next = runner1;
            } else {
                mergedHead = runner1;
            }
        } 
        if(runner2 != null) {
            if(mergedTail != null) {
                mergedTail.next = runner2;
            } else {
                mergedHead = runner2;
            }
        }
        return mergedHead;
    }
}