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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            TreeNode lastNode = null;
            while(!level.isEmpty()) {
                TreeNode current = level.removeFirst();
                if(current.left != null) {
                    nextLevel.add(current.left);
                }
                if(current.right != null) {
                    nextLevel.add(current.right);
                }
                lastNode = current;
            }
            result.add(lastNode.val);
            level = nextLevel;
        }
        return result;
    }
}