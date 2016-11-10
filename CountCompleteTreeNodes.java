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
    public int countNodes(TreeNode root) {
        int height = getHeight(root);
        int count = 0;
        while(root != null) {
            if(isComplete(root.left, height-1)) {
                count += (1 << (height-1));
                root = root.right;
            } else {
                count += (1 << (height-2));
                root = root.left;
            }
            height--;
        }
        return count;
    }
    private int getHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            root = root.left;
            height++;
        }
        return height;
    }
    private boolean isComplete(TreeNode root, int height) {
        while(root != null) {
            root = root.right;
            height--;
        }
        return (height == 0);
    }
}