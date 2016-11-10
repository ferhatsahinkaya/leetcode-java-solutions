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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n <= 0) return result;
        generateTrees(1, n, result);
        return result;
    }
    private void generateTrees(int start, int end, List<TreeNode> result) {
        if(start > end) {
            result.add(null);
        } else if(start == end) {
            result.add(new TreeNode(start));
        } else {
            for(int i=start; i<=end; i++) {
                List<TreeNode> leftTrees = new ArrayList<>();
                generateTrees(start, i-1, leftTrees);
                
                List<TreeNode> rightTrees = new ArrayList<>();
                generateTrees(i+1, end, rightTrees);
                
                for(TreeNode leftTree : leftTrees) {
                    for(TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        result.add(root);
                    }
                }
            }
        }
    }
}