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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        TreeNode prev = null;
        
        LinkedList<Integer> list = new LinkedList<>();
        list.add(root.val);
        sum -= root.val;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.empty()) {
            TreeNode current = stack.peek();
            if((prev != null) && (current.right == prev)) {
                sum += remove(stack, list);
            } else if((prev != null) && (current.left == prev)) {
                if(current.right != null) {
                    sum -= add(stack, list, current.right);
                } else {
                    sum += remove(stack, list);
                }
            } else {
                if(current.left != null) {
                    sum -= add(stack, list, current.left);
                } else if(current.right != null) {
                    sum -= add(stack, list, current.right);
                } else {
                    if(sum == 0) {
                        result.add(new ArrayList<>(list));
                    }
                    sum += remove(stack, list);
                }
            }
            prev = current;
        }
        return result;
    }
    private int add(Stack<TreeNode> stack, LinkedList<Integer> list, TreeNode node) {
        stack.push(node);
        list.add(node.val);
        return node.val;
    }
    private int remove(Stack<TreeNode> stack, LinkedList<Integer> list) {
        stack.pop();
        return list.removeLast();
    }
}