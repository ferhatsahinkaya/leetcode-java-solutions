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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if(root == null) return traversal;
        
        boolean leftToRight = true;
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> levelTraversal = new ArrayList<>();
            while(!level.isEmpty()) {
                TreeNode current = level.removeLast();
                levelTraversal.add(current.val);
                
                if(leftToRight) {
                    if(current.left != null) {
                        nextLevel.add(current.left);
                    }
                    if(current.right != null) {
                        nextLevel.add(current.right);
                    }
                } else {
                    if(current.right != null) {
                        nextLevel.add(current.right);
                    }
                    if(current.left != null) {
                        nextLevel.add(current.left);
                    }
                }
            }
            traversal.add(levelTraversal);
            level = nextLevel;
            leftToRight = !leftToRight;
        }
        return traversal;
    }
}