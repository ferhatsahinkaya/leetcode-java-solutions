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
        
        if(root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        TreeLinkNode rightChild = (root.right != null) ? root.right : root.left;
        TreeLinkNode leftMostChild = null;
        TreeLinkNode runner = root.next;
        while((runner != null) && (leftMostChild == null)) {
            leftMostChild = (runner.left != null) ? runner.left : runner.right;
            runner = runner.next;
        }
        rightChild.next = leftMostChild;
        connect(root.right);
        connect(root.left);
    }
}