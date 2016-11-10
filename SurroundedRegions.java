public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m <= 2) return;
        int n = board[0].length;
        if(n <= 2) return;
        
        for(int i=0; i<m; i++) {
            if(board[i][0] == 'O') mark(board, m, n, i, 0);
            if(board[i][n-1] == 'O') mark(board, m, n, i, n-1);
        }
        for(int i=0; i<n; i++) {
            if(board[0][i] == 'O') mark(board, m, n, 0, i);
            if(board[m-1][i] == 'O') mark(board, m, n, m-1, i);
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = (board[i][j] == 'F') ? 'O' : 'X';
            }
        }
    }
    private void mark(char[][] board, int m, int n, int i, int j) {
        Stack<Integer> stack = new Stack<>();
        stack.push(j);
        stack.push(i);
        
        while(!stack.empty()) {
            int row = stack.pop();
            int column = stack.pop();
            
            board[row][column] = 'F';
            
            if((row+1 < m) && (board[row+1][column] == 'O')) {
                stack.push(column);
                stack.push(row+1);
            }
            if((row >= 1) && (board[row-1][column] == 'O')) {
                stack.push(column);
                stack.push(row-1);
            }
            if((column+1 < n) && (board[row][column+1] == 'O')) {
                stack.push(column+1);
                stack.push(row);
            }
            if((column >= 1) && (board[row][column-1] == 'O')) {
                stack.push(column-1);
                stack.push(row);
            }            
        }
   }
}