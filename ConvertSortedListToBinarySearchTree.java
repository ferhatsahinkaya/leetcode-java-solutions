/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        
        prev.next = null;
        ListNode slowNext = slow.next;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slowNext);
        return root;
    }
}