public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows <= 0) return triangle;
        
        List<Integer> level = new ArrayList<>();
        level.add(1);
        triangle.add(level);
        
        for(int i=1; i<numRows; i++) {
            List<Integer> nextLevel = new ArrayList<>();
            nextLevel.add(1);
            for(int j=1; j<level.size(); j++) {
                nextLevel.add(level.get(j-1) + level.get(j));
            }
            nextLevel.add(1);
            triangle.add(nextLevel);
            level = nextLevel;
        }
        return triangle;
    }
}