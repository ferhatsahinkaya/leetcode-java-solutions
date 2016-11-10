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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        return buildTree(preorder, 0, length-1, inorder, 0, length-1);
    }
    private TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if(prestart > preend) return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int rootIndex = getRootIndex(inorder, instart, inend, preorder[prestart]);
        int leftCount = rootIndex - instart;
        root.left = buildTree(preorder, prestart+1, prestart+leftCount, inorder, instart, rootIndex-1);
        root.right = buildTree(preorder, prestart+leftCount+1, preend, inorder, rootIndex+1, inend);
        return root;
    }
    private int getRootIndex(int[] inorder, int start, int end, int value) {
        for(int i=start; i<=end; i++) {
            if(value == inorder[i]) return i;
        }
        return -1;
    }
}