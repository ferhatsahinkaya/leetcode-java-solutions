public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(!isEmpty(board[i][j]) && !isValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int column) {
        for(int i=0; i<9; i++) {
            if((row != i) && (board[i][column] == board[row][column])) return false;
        }
        for(int i=0; i<9; i++) {
            if((column != i) && (board[row][i] == board[row][column])) return false;
        }
        
        int rowStart = (row / 3) * 3;
        int columnStart = (column / 3) * 3;
        
        for(int i=rowStart; i<rowStart+3; i++) {
            for(int j=columnStart; j<columnStart+3; j++) {
                if(((i != row) || (j != column)) && (board[i][j] == board[row][column])) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isEmpty(char ch) {
        return (ch == '.');
    }
}