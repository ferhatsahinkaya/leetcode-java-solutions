public class NumMatrix {
    private int m = 0;
    private int n = 0;
    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        if(m <= 0) return;
        n = matrix[0].length;
        if(n <= 0) return;
        
        sum = new int[m][n];
        sum[m-1][n-1] = matrix[m-1][n-1];
        for(int i=m-2; i >= 0; i--) {
            sum[i][n-1] = sum[i+1][n-1] + matrix[i][n-1];
        }
        for(int i=n-2; i >= 0; i--) {
            sum[m-1][i] = sum[m-1][i+1] + matrix[m-1][i];
        }
        for(int i=m-2; i >= 0; i--) {
            for(int j=n-2; j >= 0; j--) {
                sum[i][j] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i+1][j+1]; 
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row1][col1]
                - ((col2 + 1 < n) ? sum[row1][col2+1] : 0)
                - ((row2 + 1 < m) ? sum[row2+1][col1] : 0)
                + ((row2 + 1 < m && col2 + 1 < n) ? sum[row2+1][col2+1] : 0);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);