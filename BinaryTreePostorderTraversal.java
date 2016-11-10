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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if(root == null) return traversal;
        
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        Stack<Integer> stack = new Stack<>();
        while(!list.isEmpty()) {
            TreeNode current = list.removeFirst();
            if(current.left != null) {
                list.addFirst(current.left);
            }
            if(current.right != null) {
                list.addFirst(current.right);
            }
            stack.push(current.val);
        }
        while(!stack.empty()) traversal.add(stack.pop());
        return traversal;
    }
}