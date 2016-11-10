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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int total = 0;
        int sum = root.val;
        while(!stack.empty()) {
            TreeNode current = stack.peek();
            if((prev != null) && (current.right == prev)) {
                sum = remove(stack, sum);
            } else if((prev != null) && (current.left == prev)) {
                if(current.right != null) {
                    sum = add(stack, current.right, sum);
                } else {
                    sum = remove(stack, sum);
                }
            } else {
                if(current.left != null) {
                    sum = add(stack, current.left, sum);
                } else if(current.right != null) {
                    sum = add(stack, current.right, sum);
                } else {
                    total += sum;
                    sum = remove(stack, sum);
                }
            }
            prev = current;
        }
        return total;
    }
    private int remove(Stack<TreeNode> stack, int sum) {
        return (sum - stack.pop().val) / 10;
    }
    private int add(Stack<TreeNode> stack, TreeNode node, int sum) {
        stack.push(node);
        return sum * 10 + node.val;
    }
}