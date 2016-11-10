/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    class TreeInformation {
        private final TreeNode root;
        private final int end;
        TreeInformation(TreeNode root, int end) {
            this.root = root;
            this.end = end;
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        TreeInformation tree = deserialize(values, 0, values.length-1);
        return tree.root;
    }
    
    private TreeInformation deserialize(String[] data, int start, int end) {
        if(data[start].equals("#")) return new TreeInformation(null, start);
        TreeNode root = new TreeNode(Integer.parseInt(data[start]));
        TreeInformation rootLeft = deserialize(data, start+1, end);
        root.left = rootLeft.root;
        TreeInformation rootRight = deserialize(data, rootLeft.end+1, end);
        root.right = rootRight.root;
        return new TreeInformation(root, rootRight.end);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));