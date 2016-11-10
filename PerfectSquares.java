public class Solution {
    public int numSquares(int n) {
        int sqrt = ((int) Math.sqrt(n)) + 1;
        
        int[] values = new int[sqrt];
        for(int i=0; i<sqrt; i++) {
            values[i] = (i+1) * (i+1);
        }
        
        int[] counts = new int[n+1];
        Arrays.fill(counts, Integer.MAX_VALUE);
        counts[0] = 0;
        
        for(int i=1; i<=n; i++) {
            int count = Integer.MAX_VALUE;
            for(int j=0; j<sqrt; j++) {
                count = Math.min(count, ((i >= values[j]) && (counts[i-values[j]] != Integer.MAX_VALUE)) 
                    ? counts[i-values[j]]+1 
                    : Integer.MAX_VALUE);
            }
            counts[i] = count;
        }
        return counts[n];
    }
}