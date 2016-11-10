public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(isEmpty(board[i][j])) {
                    for(char ch : getValidChars(board, i, j)) {
                        board[i][j] = ch;
                        if(solve(board)) return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private Set<Character> getValidChars(char[][] board, int i, int j) {
        Set<Character> validChars = allChars();
        for(int row=0; row<9; row++) {
            if(!isEmpty(board[row][j])) {
                validChars.remove(board[row][j]);
            }
        }
        for(int column=0; column<9; column++) {
            if(!isEmpty(board[i][column])) {
                validChars.remove(board[i][column]);
            }
        }
        int rowStart = (i / 3) * 3;
        int columnStart = (j / 3) * 3;
        for(int row=rowStart; row<rowStart+3; row++) {
            for(int column=columnStart; column<columnStart+3; column++) {
                if(!isEmpty(board[row][column])) {
                    validChars.remove(board[row][column]);
                }
            }
        }
        return validChars;
    }
    private static Set<Character> allChars() {
        Set<Character> chars = new HashSet<>();
        for(char ch='1'; ch<='9'; ch++) {
            chars.add(ch);
        }
        return chars;
    }
    private boolean isEmpty(char ch) {
        return ch == '.';
    }
}