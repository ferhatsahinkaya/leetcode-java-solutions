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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return (Math.abs(rightDepth - leftDepth) <= 1)
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
    private int depth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}