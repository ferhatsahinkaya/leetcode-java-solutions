public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> traversal = new ArrayList<>();
        int m = matrix.length;
        if(m <= 0) return traversal;
        int n = matrix[0].length;
        if(n <= 0) return traversal;
        
        int i=0;
        while(i<m/2 && i<n/2) {
            for(int j=i; j<n-1-i; j++) {
                traversal.add(matrix[i][j]);
            }
            for(int j=i; j<m-1-i; j++) {
                traversal.add(matrix[j][n-1-i]);
            }
            for(int j=n-1-i; j>i; j--) {
                traversal.add(matrix[m-1-i][j]);
            }
            for(int j=m-1-i; j>i; j--) {
                traversal.add(matrix[j][i]);
            }
            i++;
        }
        
        if((m % 2 == 1) && ((m-1) / 2 == i)) {
            for(int j=i; j<=n-1-i; j++) {
                traversal.add(matrix[i][j]);
            }
        } else if((n % 2 == 1) && ((n-1) / 2 == i)) {
            for(int j=i; j<=m-1-i; j++) {
                traversal.add(matrix[j][i]);
            }
        }
        return traversal;
    }
}