public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m <= 0) return 0;
        int n = matrix[0].length;
        if(n <= 0) return 0;
        
        int[][] squares = new int[m][n];
        int maxSquareSize = 0;
        for(int i=0; i<n; i++) {
            squares[0][i] = matrix[0][i] - '0';
            maxSquareSize = Math.max(squares[0][i], maxSquareSize);
        }
        for(int i=0; i<m; i++) {
            squares[i][0] = matrix[i][0] - '0';
            maxSquareSize = Math.max(squares[i][0], maxSquareSize);
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                squares[i][j] = (matrix[i][j] == '0') ? 0
                                                      : Math.min(squares[i-1][j-1], Math.min(squares[i-1][j], squares[i][j-1])) + 1;
                maxSquareSize = Math.max(maxSquareSize, squares[i][j] * squares[i][j]);
            }
        }
        return maxSquareSize;
    }
}