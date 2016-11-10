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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if(root == null) return traversal;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while(!stack.empty()) {
            TreeNode current = stack.peek();
            if((prev != null) && (prev == current.right)) {
                stack.pop();
            } else if((prev != null) && (prev == current.left)) {
                traversal.add(current.val);
                if(current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                }
            } else {
                if(current.left != null) {
                    stack.push(current.left);
                } else {
                    traversal.add(current.val);
                    if(current.right != null) {
                        stack.push(current.right);
                    } else {
                        stack.pop();
                    }
                }
            }
            prev = current;
        }
        return traversal;
    }
}