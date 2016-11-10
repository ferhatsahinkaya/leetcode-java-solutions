public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if(m <= 0) return 0;
        int n = board[0].length;
        if(n <= 0) return 0;
        
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(isValidStart(board, m, n, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isValidStart(char[][] board, int m, int n, int i, int j) {
        if(board[i][j] != 'X') return false;
        if((i >= 1) && board[i-1][j] == 'X') return false;
        if((j >= 1) && board[i][j-1] == 'X') return false;
        return true;
    }
}