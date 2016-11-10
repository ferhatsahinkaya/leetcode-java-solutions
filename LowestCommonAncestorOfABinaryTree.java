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
        if(p == null) return q;
        if(q == null) return p;
        if(p == q) return p;
        
        LinkedList<TreeNode> pPath = findPath(root, p);
        LinkedList<TreeNode> qPath = findPath(root, q);
        
        TreeNode lowestCommonAncestor = null;
        while(!pPath.isEmpty() && !qPath.isEmpty()) {
            TreeNode pAsc = pPath.removeFirst();
            TreeNode qAsc = qPath.removeFirst();
            if(pAsc != qAsc) break;
            lowestCommonAncestor = pAsc;
        }
        return lowestCommonAncestor;
    }
    private LinkedList<TreeNode> findPath(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> path = new LinkedList<>();
        if(p == null) return path;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        TreeNode prev = null;
        while(!stack.empty()) {
            TreeNode current = stack.peek();
            if(current == p) break;
            if((prev != null) && (current.right == prev)) {
                stack.pop();
            } else if((prev != null) && (current.left == prev)) {
                if(current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                }
            } else {
                if(current.left != null) {
                    stack.push(current.left);
                } else if(current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                }
            }
            prev = current;
        }
        while(!stack.empty()) {
            path.addFirst(stack.pop());
        }
        return path;
    }
}