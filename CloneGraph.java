/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private final Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for(UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode copyNeighbor = map.get(neighbor);
            copyNeighbor = (copyNeighbor != null) ? copyNeighbor : cloneGraph(neighbor);
            newNode.neighbors.add(copyNeighbor);
        }
        return newNode;
    }
}