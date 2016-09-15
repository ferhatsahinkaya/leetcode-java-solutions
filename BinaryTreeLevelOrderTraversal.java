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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if(root == null) return traversal;
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);
        
        while(!level.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> levelTraversal = new ArrayList<>();
            while(!level.isEmpty()) {
                TreeNode current = level.removeFirst();
                levelTraversal.add(current.val);
                
                if(current.left != null) {
                    nextLevel.add(current.left);
                }
                if(current.right != null) {
                    nextLevel.add(current.right);
                }
            }
            traversal.add(levelTraversal);
            level = nextLevel;
        }
        return traversal;
    }
}