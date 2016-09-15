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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> traversal = new LinkedList<>();
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
            traversal.addFirst(levelTraversal);
            level = nextLevel;
        }
        return traversal;
    }
}