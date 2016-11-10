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
    private static final Map<TreeNode, Long> withRootMap = new HashMap<>();
    private static final Map<TreeNode, Long> withoutRootMap = new HashMap<>();
    
    static {
        withRootMap.put(null, (long) Integer.MIN_VALUE);
        withoutRootMap.put(null, (long) Integer.MIN_VALUE);
    }
    public int maxPathSum(TreeNode root) {
        return (int) Math.max(maxPathSum(root, true), maxPathSum(root, false));
    }
    private long maxPathSum(TreeNode root, boolean includeRoot) {
        Map<TreeNode, Long> map = includeRoot ? withRootMap : withoutRootMap;
        if(map.get(root) != null) return map.get(root);
        
        long maxValue = Integer.MIN_VALUE;
        if(includeRoot) {
            long left = maxPathSum(root.left, true);
            long right = maxPathSum(root.right, true);
            long leftWithRoot = root.val + left;
            long rightWithRoot = root.val + right;
            
            maxValue = Math.max(root.val, Math.max(leftWithRoot, rightWithRoot));
        } else {
            long left = maxPathSum(root.left, true);
            long right = maxPathSum(root.right, true);
            long leftRightWithRoot = root.val + left + right;
            
            maxValue = Math.max(leftRightWithRoot, Math.max(maxPathSum(root.left), maxPathSum(root.right)));
        }
        map.put(root, maxValue);
        return maxValue;
    }
}