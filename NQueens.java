public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        if(n <= 0) return solution;
        
        int[] columns = new int[n];
        solveNQueens(0, n-1, 0, columns, solution);
        return solution;
    }
    private void solveNQueens(int start, int end, int index, int[] columns, List<List<String>> solution) {
        if(index > end) {
            solution.add(getString(columns, start, end));
        } else {
            for(int i=start; i<=end; i++) {
                if(isValid(index, i, columns)) {
                    columns[index] = i;
                    solveNQueens(start, end, index+1, columns, solution);
                }
            }
        }
    }
    private List<String> getString(int[] columns, int start, int end) {
        List<String> board = new ArrayList<>();
        for(int i=start; i<=end; i++) {
            String row = "";
            for(int j=start; j<columns[i]; j++) {
                row += ".";
            }
            row += "Q";
            for(int j=columns[i]+1; j<=end; j++) {
                row += ".";
            }
            board.add(row);
        }
        return board;
    }
    private boolean isValid(int row, int column, int[] columns) {
        for(int i=0; i<row; i++) {
            if((columns[i] == column) || (Math.abs(row - i) == Math.abs(columns[i] - column))) return false;
        }
        return true;
    }
}