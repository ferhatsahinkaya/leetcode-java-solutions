public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowCount = triangle.size();
        if(rowCount == 1) return triangle.get(0).get(0);
        
        int minTotal = Integer.MAX_VALUE;
        for(int i=1; i<rowCount; i++) {
            for(int j=0; j<=i; j++) {
                int left = (j > 0) ? triangle.get(i-1).get(j-1) : Integer.MAX_VALUE;
                int right = (j < i) ? triangle.get(i-1).get(j) : Integer.MAX_VALUE;
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(left, right));
                
                if(i == rowCount-1) {
                    minTotal = Math.min(minTotal, triangle.get(i).get(j));
                }
            }
        }
        return minTotal;
    }
}