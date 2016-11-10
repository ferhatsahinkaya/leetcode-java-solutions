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
    private final Map<TreeNode, Integer> withMap = new HashMap<>();
    private final Map<TreeNode, Integer> withoutMap = new HashMap<>();
    public int rob(TreeNode root) {
        return Math.max(rob(root, false), 
                        rob(root, true));
    }
    private int rob(TreeNode root, boolean useRoot) {
        if(root == null) return 0;
        
        Map<TreeNode, Integer> map = useRoot ? withMap : withoutMap;
        Integer amount = map.get(root);
        if(amount == null) {
            amount = useRoot ? (root.val + rob(root.left, false) + rob(root.right, false))
                             : (rob(root.left) + rob(root.right));
        }
        map.put(root, amount);
        return amount;
    }
}