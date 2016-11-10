public class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        
        TrieNode() {
            Arrays.fill(children, null);
        }
        
        private void add(String word, int start, int end) {
            if(start > end) isEnd = true;
            else {
                int chIndex = word.charAt(start) - 'a';
                TrieNode child = children[chIndex];
                child = (child != null) ? child : new TrieNode();
                children[chIndex] = child;
                child.add(word, start+1, end);
            }
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        if(m <= 0) return new ArrayList<>();
        int n = board[0].length;
        if(n <= 0) return new ArrayList<>();
        boolean[][] used = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                used[i][j] = false;
            }
        }
        
        TrieNode root = new TrieNode();
        for(String word : words) {
            root.add(word, 0, word.length()-1);
        }
        
        Set<String> result = new HashSet<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int chIndex = board[i][j] - 'a';
                TrieNode child = root.children[chIndex];
                if(child != null) {
                    findWords(board, m, n, used, i, j, child, String.valueOf(board[i][j]), result);
                }
            }
        }
        return new ArrayList<>(result);
    }
    private void findWords(char[][] board, int m, int n, boolean[][] used, int i, int j, TrieNode root, String current, Set<String> result) {
        used[i][j] = true;
        if(root.isEnd) result.add(current);
        
        if((i+1 < m) && !used[i+1][j] && (root.children[board[i+1][j]-'a'] != null)) {
            findWords(board, m, n, used, i+1, j, root.children[board[i+1][j]-'a'], current + String.valueOf(board[i+1][j]), result);
        }
        if((i >= 1) && !used[i-1][j] && (root.children[board[i-1][j]-'a'] != null)) {
            findWords(board, m, n, used, i-1, j, root.children[board[i-1][j]-'a'], current + String.valueOf(board[i-1][j]), result);
        }
        if((j+1 < n) && !used[i][j+1] && (root.children[board[i][j+1]-'a'] != null)) {
            findWords(board, m, n, used, i, j+1, root.children[board[i][j+1]-'a'], current + String.valueOf(board[i][j+1]), result);
        }
        if((j >= 1) && !used[i][j-1] && (root.children[board[i][j-1]-'a'] != null)) {
            findWords(board, m, n, used, i, j-1, root.children[board[i][j-1]-'a'], current + String.valueOf(board[i][j-1]), result);
        }
        used[i][j] = false;
    }
}