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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        return buildTree(inorder, 0, length-1, postorder, 0, length-1);
    }
    private TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if(instart > inend) return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int rootIndex = getIndex(inorder, instart, inend, postorder[postend]);
        int leftCount = rootIndex-instart;
        root.left = buildTree(inorder, instart, rootIndex-1, postorder, poststart, poststart+leftCount-1);
        root.right = buildTree(inorder, rootIndex+1, inend, postorder, poststart+leftCount, postend-1);
        return root;
    }
    private int getIndex(int[] order, int start, int end, int value) {
        for(int i=start; i<=end; i++) {
            if(order[i] == value) return i;
        }
        return -1;
    }
}