public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> level = new ArrayList<>();
        level.add(1);

        for(int i=0; i<rowIndex; i++) {
            List<Integer> nextLevel = new ArrayList<>();
            nextLevel.add(1);
            for(int j=1; j<=i; j++) {
                nextLevel.add(level.get(j-1) + level.get(j));
            }
            nextLevel.add(1);
            level = nextLevel;
        }
        return level;
    }
}