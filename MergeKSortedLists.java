/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length <= 0) return null;
        
        int diff = 1;
        while(diff < length) {
            for(int i=0; i+diff<length; i+=2*diff) {
                lists[i] = merge(lists[i], lists[i+diff]);
                lists[i+diff] = null;
            }
            diff *= 2;
        }
        return lists[0];
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode head = null;
        ListNode tail = null;
        
        ListNode runner1 = l1;
        ListNode runner2 = l2;
        while((runner1 != null) && (runner2 != null)) {
            int val = (runner1.val <= runner2.val) ? runner1.val : runner2.val;
            ListNode newNode = new ListNode(val);
            if(head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            if(runner1.val <= runner2.val) {
                runner1 = runner1.next;
            } else {
                runner2 = runner2.next;
            }
        }
        ListNode remaining = (runner1 != null) ? runner1 : runner2;
        if(remaining != null) {
            if(tail == null) {
                head = tail = remaining;
            } else {
                tail.next = remaining;
            }
        }
        return head;
    }
}