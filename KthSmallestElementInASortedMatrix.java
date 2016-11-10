public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(n <= 0) return -1;
        
        int[] indexes = new int[n];
        Arrays.fill(indexes, 0);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            queue.add(matrix[i][0]);
        }
        
        for(int i=0; i<k-1; i++) {
            queue.poll();
            
            int minValue = Integer.MAX_VALUE;
            int minValueIndex = -1;
            for(int j=0; j<n; j++) {
                if((indexes[j] + 1 < n) && (minValue > matrix[j][indexes[j]+1])) {
                    minValue = matrix[j][indexes[j]+1];
                    minValueIndex = j;
                }
            }
            if(minValueIndex != -1) {
                indexes[minValueIndex]++;
                queue.add(minValue);
            }
        }
        return queue.poll();
    }
}