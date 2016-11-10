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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if(root == null) return true;
        return (minValue < root.val) 
                && (root.val < maxValue)
                && isValidBST(root.left, minValue, root.val)
                && isValidBST(root.right, root.val, maxValue);
    }
}