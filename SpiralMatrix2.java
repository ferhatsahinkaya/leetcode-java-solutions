public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n <= 0) return matrix;
        
        int number = 1;
        for(int i=0; i<n/2; i++) {
            for(int j=i; j<n-1-i; j++) {
                matrix[i][j] = number++;
            }
            for(int j=i; j<n-1-i; j++) {
                matrix[j][n-1-i] = number++;
            }
            for(int j=n-1-i; j>i; j--) {
                matrix[n-1-i][j] = number++;
            }
            for(int j=n-1-i; j>i; j--) {
                matrix[j][i] = number++;
            }
        }
        if(n % 2 > 0) {
            matrix[n/2][n/2] = number;
        }
        return matrix;
    }
}