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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null) return paths;
        binaryTreePaths(root, paths, "");
        return paths;
    }
    private void binaryTreePaths(TreeNode root, List<String> paths, String path) {
        if(root.left == null && root.right == null) paths.add(addPath(path, root.val));
        if(root.left != null) binaryTreePaths(root.left, paths, addPath(path, root.val));
        if(root.right != null) binaryTreePaths(root.right, paths, addPath(path, root.val));
    }
    private String addPath(String path, int newValue) {
        return path.equals("") ? String.valueOf(newValue) : (path + "->" + String.valueOf(newValue));
    }
}