public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m <= 0) return;
        int n = matrix[0].length;
        if(n <= 0) return;
        
        boolean clearFirstRow = (matrix[0][0] == 0);
        boolean clearFirstColumn = clearFirstRow;
        
        for(int i=0; i<m && !clearFirstColumn; i++) {
            clearFirstColumn = clearFirstColumn || (matrix[i][0] == 0);
        }
        for(int i=0; i<n; i++) {
            clearFirstRow = clearFirstRow || (matrix[0][i] == 0);
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(clearFirstColumn) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
        if(clearFirstRow) {
            for(int i=0; i<n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}