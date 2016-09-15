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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) return root;
        if(p.val > q.val) return lowestCommonAncestor(root, q, p);
        
        while(root != null) {
            if(root.val >= p.val && root.val <= q.val) break;
            root = (root.val >= q.val) ? root.left : root.right;
        }
        return root;
    }
}