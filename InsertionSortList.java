/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode sorted = null;
        ListNode runner = head;
        while(runner != null) {
            ListNode runnerNext = runner.next;
            sorted = add(sorted, runner);
            runner = runnerNext;
        }
        return sorted;
    }
    private ListNode add(ListNode sorted, ListNode newElement) {
        newElement.next = null;
        if(sorted == null) return newElement;
        
        ListNode lastLess = null;
        ListNode runner = sorted;
        while(runner != null) {
            if(runner.val >= newElement.val) {
                break;
            }
            lastLess = runner;
            runner = runner.next;
        }
        if(lastLess == null) {
            newElement.next = sorted;
            sorted = newElement;
        } else {
            lastLess.next = newElement;
            newElement.next = runner;
        }
        return sorted;
    }
}