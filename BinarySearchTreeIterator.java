/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private final Stack<TreeNode> stack = new Stack<>();
    private TreeNode prev = null;
    
    public BSTIterator(TreeNode root) {
        if(root != null) add(root);
    }
    
    private void add(TreeNode root) {
        stack.push(root);
        while(root.left != null) {
            stack.push(root.left);
            prev = root;
            root = root.left;
        }
    }
    
    private void remove(Stack<TreeNode> stack) {
        do {
            prev = stack.pop();
        } while(!stack.empty() && (prev == stack.peek().right));
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.peek();
        if((prev != null) && (current.right == prev)) {
            remove(stack);
        } else if((prev != null) && (current.left == prev)) {
            if(current.right != null) {
                prev = current;
                add(current.right);
            } else {
                remove(stack);
            }
        } else {
            if(current.left != null) {
                prev = current.left;
                add(current.left);
            } else if(current.right != null) {
                prev = current.right;
                add(current.right);
            } else {
                remove(stack);
            }
        }
        return current.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */