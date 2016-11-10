public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int edgeCount = edges.length;
        for(int i=0; i<edgeCount; i++) {
            Set<Integer> neighbors = map.get(edges[i][0]);
            neighbors = (neighbors != null) ? neighbors : new HashSet<>();
            neighbors.add(edges[i][1]);
            map.put(edges[i][0], neighbors);
            
            neighbors = map.get(edges[i][1]);
            neighbors = (neighbors != null) ? neighbors : new HashSet<>();
            neighbors.add(edges[i][0]);
            map.put(edges[i][1], neighbors);
        }

        for(int i=0; i<n; i++) {
            Set<Integer> neighbors = map.get(i);
            neighbors = (neighbors != null) ? neighbors : new HashSet<>();
            map.put(i, neighbors);
        }
        
        while(map.size() > 2) {
            Set<Integer> dontRemove = new HashSet<>();
            Iterator<Map.Entry<Integer, Set<Integer>>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()) {
                Map.Entry<Integer, Set<Integer>> entry = iterator.next();
                Set<Integer> neighbors = entry.getValue();
                if(neighbors.isEmpty()) {
                    iterator.remove();
                } else if((neighbors.size() == 1) && !dontRemove.contains(entry.getKey())) {
                    Iterator<Integer> it = neighbors.iterator();
                    int neighbor = it.next();
                    dontRemove.add(neighbor);
                    it.remove();
                    
                    map.get(neighbor).remove(entry.getKey());
                    iterator.remove();
                }
            }
        }
        return new ArrayList<>(map.keySet());
    }
}