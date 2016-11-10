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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return sumOfLeftLeaves(root, false);
    }
    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        return ((isLeft && (root.left == null) && (root.right == null)) ? root.val : 0)
               + ((root.left != null) ? sumOfLeftLeaves(root.left, true) : 0)
               + ((root.right != null) ? sumOfLeftLeaves(root.right, false) : 0);
    }
}