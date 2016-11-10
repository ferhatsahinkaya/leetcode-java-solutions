public class Solution {
    public int totalNQueens(int n) {
        int[] columns = new int[n];
        return totalNQueens(0, n-1, 0, columns);
    }
    private int totalNQueens(int start, int end, int index, int[] columns) {
        if(index > end) return 1;
        
        int total = 0;
        for(int i=start; i<=end; i++) {
            if(isValid(index, i, columns)) {
                columns[index] = i;
                total += totalNQueens(start, end, index+1, columns);
            }
        }
        return total;
    }
    private boolean isValid(int row, int column, int[] columns) {
        for(int i=0; i<row; i++) {
            if((columns[i] == column) || (Math.abs(i - row) == Math.abs(columns[i] - column))) return false;
        }
        return true;
    }
}