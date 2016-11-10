public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m <= 0) return 0;
        int n = grid[0].length;
        if(n <= 0) return 0;
        
        int islandCount = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    mark(grid, m, n, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    private void mark(char[][] grid, int m, int n, int i, int j) {
        grid[i][j] = 'x';
        if((i+1 < m) && (grid[i+1][j] == '1')) {
            mark(grid, m, n, i+1, j);
        }
        if((i-1 >= 0) && (grid[i-1][j] == '1')) {
            mark(grid, m, n, i-1, j);
        }
        if((j+1 < n) && (grid[i][j+1] == '1')) {
            mark(grid, m, n, i, j+1);
        }
        if((j-1 >= 0) && (grid[i][j-1] == '1')) {
            mark(grid, m, n, i, j-1);
        }
    }
}