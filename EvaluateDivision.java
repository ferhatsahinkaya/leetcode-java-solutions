public class Solution {
    class Neighbor {
        String name;
        double weight;
        
        Neighbor(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }
    }
    private Map<String, List<Neighbor>> map = new HashMap<>();
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int edgeCount = equations.length;
        for(int i=0; i<edgeCount; i++) {
            List<Neighbor> neighbors = map.get(equations[i][0]);
            neighbors = (neighbors != null) ? neighbors : new ArrayList<>();
            neighbors.add(new Neighbor(equations[i][1], values[i]));
            map.put(equations[i][0], neighbors);
            
            List<Neighbor> neighbors2 = map.get(equations[i][1]);
            neighbors2 = (neighbors2 != null) ? neighbors2 : new ArrayList<>();
            neighbors2.add(new Neighbor(equations[i][0], 1.0 / values[i]));
            map.put(equations[i][1], neighbors2);
        }
        
        int queryCount = queries.length;
        double[] result = new double[queryCount];
        for(int i=0; i<queryCount; i++) {
            Double queryResult = -1.0;
            if(map.get(queries[i][0]) != null) {
                queryResult = evaluate(queries[i][0], queries[i][1], 1.0, new HashSet<>());
            }
            result[i] = (queryResult != null) ? queryResult : -1.0;
        }
        return result;
    }
    private Double evaluate(String from, String to, double weight, Set<String> used) {
        used.add(from);
        if(from.equals(to)) return weight;
        List<Neighbor> neighbors = map.get(from);
        neighbors = (neighbors != null) ? neighbors : new ArrayList<>();
        Double result = null;
        for(Neighbor neighbor : neighbors) {
            if(!used.contains(neighbor.name)) {
                result = evaluate(neighbor.name, to, weight * neighbor.weight, used);
                if(result != null) break;
            }
        }
        return result;
    }
}