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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        LinkedList<Integer> path = new LinkedList<>();
        
        int count = 0;
        
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        add(stack, path, root);
        
        while(!stack.empty()) {
            TreeNode current = stack.peek();
            if((prev != null) && (current.right == prev)) {
                count += getCount(path, sum);
                remove(stack, path);
            } else if((prev != null) && (current.left == prev)) {
                if(current.right != null) {
                    add(stack, path, current.right);
                } else {
                    count += getCount(path, sum);
                    remove(stack, path);
                }
            } else {
                if(current.left != null) {
                    add(stack, path, current.left);
                } else if(current.right != null) {
                    add(stack, path, current.right);
                } else {
                    count += getCount(path, sum);
                    remove(stack, path);
                }
            }
            prev = current;
        }
        return count;
    }
    private int getCount(List<Integer> list, int target) {
        int count = 0;
        int sum = 0;
        for(Integer value : list) {
            sum += value;
            if(target == sum) count++; 
        }
        return count;
    }
    private void remove(Stack<TreeNode> stack, LinkedList<Integer> path) {
        stack.pop();
        path.removeFirst();
    }
    private void add(Stack<TreeNode> stack, LinkedList<Integer> path, TreeNode node) {
        stack.push(node);
        path.addFirst(node.val);
    }
}