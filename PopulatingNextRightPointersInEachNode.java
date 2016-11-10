/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        if(root.next != null) {
            root.right.next = root.next.left;
        }
        root.left.next = root.right;
        connect(root.left);
        connect(root.right);
    }
}