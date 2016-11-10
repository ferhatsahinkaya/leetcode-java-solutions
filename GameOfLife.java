public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if(m <= 0) return;
        int n = board[0].length;
        if(n <= 0) return;
        
        int[][] previousBoard = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                previousBoard[i][j] = board[i][j];
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int liveNeighborCount = getLiveNeighborCount(previousBoard, m, n, i, j);
                if(isLive(previousBoard[i][j])) {
                    if(liveNeighborCount < 2 || liveNeighborCount > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    board[i][j] = (liveNeighborCount == 3) ? 1 : 0;
                }
            }
        }
    }
    private int getLiveNeighborCount(int[][] board, int m, int n, int i, int j) {
        int count = 0;
        boolean isNextRowValid = (i+1 < m);
        boolean isPreviousRowValid = (i >= 1);
        boolean isNextColumnValid = (j+1 < n);
        boolean isPreviousColumnValid = (j >= 1);
        
        if(isNextRowValid && isLive(board[i+1][j])) count++;
        if(isPreviousRowValid && isLive(board[i-1][j])) count++;
        if(isNextColumnValid && isLive(board[i][j+1])) count++;
        if(isPreviousColumnValid && isLive(board[i][j-1])) count++;
        if(isNextRowValid && isNextColumnValid && isLive(board[i+1][j+1])) count++;
        if(isNextRowValid && isPreviousColumnValid && isLive(board[i+1][j-1])) count++;
        if(isPreviousRowValid && isNextColumnValid && isLive(board[i-1][j+1])) count++;
        if(isPreviousRowValid && isPreviousColumnValid && isLive(board[i-1][j-1])) count++;
        return count;
    }
    private boolean isLive(int value) {
        return value > 0;
    }
}