public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(m <= 0) return 0;
        int n = matrix[0].length;
        if(n <= 0) return 0;
        
        int[][] lengths = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                lengths[i][j] = -1;
            }
        }
        
        int maxLength = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                maxLength = Math.max(maxLength, find(matrix, m, n, i, j, lengths, 1));
            }
        }
        return maxLength;
    }
    private int find(int[][] matrix, int m, int n, int i, int j, int[][] lengths, int length) {
        if(lengths[i][j] != -1) return lengths[i][j];
        
        int restLength = 0;
        if((i+1 < m) && (matrix[i][j] < matrix[i+1][j])) {
            restLength = Math.max(restLength, find(matrix, m, n, i+1, j, lengths, 1));
        }
        if((i >= 1) && (matrix[i][j] < matrix[i-1][j])) {
            restLength = Math.max(restLength, find(matrix, m, n, i-1, j, lengths, 1));
        }
        if((j+1 < n) && (matrix[i][j] < matrix[i][j+1])) {
            restLength = Math.max(restLength, find(matrix, m, n, i, j+1, lengths, 1));
        }
        if((j >= 1) && (matrix[i][j] < matrix[i][j-1])) {
            restLength = Math.max(restLength, find(matrix, m, n, i, j-1, lengths, 1));
        }
        lengths[i][j] = restLength + 1;
        return lengths[i][j];
    }
}