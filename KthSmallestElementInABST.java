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
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        childCount(map, root);
        return kthSmallest(root, k-1, map);
    }
    private int kthSmallest(TreeNode root, int k, Map<TreeNode, Integer> map) {
        int leftCount = map.get(root.left);
        if(leftCount == k) return root.val;
        if(leftCount > k) return kthSmallest(root.left, k, map);
        return kthSmallest(root.right, k-leftCount-1, map);
    }
    private int childCount(Map<TreeNode, Integer> map, TreeNode root) {
        Integer cachedCount = map.get(root);
        if(cachedCount != null) return cachedCount;
        
        int count = childCount(map, root.left) + childCount(map, root.right) + 1;
        map.put(root, count);
        return count;
    }
}