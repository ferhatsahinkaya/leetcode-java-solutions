public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m <= 0) return false;
        int n = board[0].length;
        if(n <= 0) return false;
        
        boolean[][] used = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                used[i][j] = false;
            }
        }
        
        int length = word.length();
        if(length <= 0) return false;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(exists(board, used, m, n, i, j, word, 0, length-1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean exists(char[][] board, boolean[][] used, int m, int n, int i, int j, String word, int start, int end) {
        if(start >= end) return true;
        used[i][j] = true;
        
        boolean found = false;
        if((i+1 < m) && !used[i+1][j] && (board[i+1][j] == word.charAt(start+1))) {
            found = exists(board, used, m, n, i+1, j, word, start+1, end);
        }
        if(!found && (i >= 1) && !used[i-1][j] && (board[i-1][j] == word.charAt(start+1))) {
            found = exists(board, used, m, n, i-1, j, word, start+1, end);
        }
        if(!found && (j+1 < n) && !used[i][j+1] && (board[i][j+1] == word.charAt(start+1))) {
            found = exists(board, used, m, n, i, j+1, word, start+1, end);
        }
        if(!found && (j >= 1) && !used[i][j-1] && (board[i][j-1] == word.charAt(start+1))) {
            found = exists(board, used, m, n, i, j-1, word, start+1, end);
        }
        
        used[i][j] = false;
        return found;
    }
}