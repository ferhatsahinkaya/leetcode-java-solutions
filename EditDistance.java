public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if(length1 <= 0) return length2;
        if(length2 <= 0) return length1;
        
        int[][] matrix = new int[length1][length2];
        boolean sameFound = (word1.charAt(0) == word2.charAt(0));
        matrix[0][0] = sameFound ? 0 : 1;
        for(int i=1; i<length1; i++) {
            if(sameFound) {
                matrix[i][0] = matrix[i-1][0] + 1;
            } else {
                sameFound = (word1.charAt(i) == word2.charAt(0));
                matrix[i][0] = matrix[i-1][0] + (sameFound ? 0 : 1);
            }
        }
        sameFound = (word1.charAt(0) == word2.charAt(0));
        for(int i=1; i<length2; i++) {
            if(sameFound) {
                matrix[0][i] = matrix[0][i-1] + 1;
            } else {
                sameFound = (word1.charAt(0) == word2.charAt(i));
                matrix[0][i] = matrix[0][i-1] + (sameFound ? 0 : 1);
            }
        }
        for(int i=1; i<length1; i++) {
            for(int j=1; j<length2; j++) {
                int left = matrix[i][j-1] + 1;
                int up = matrix[i-1][j] + 1;
                int diag = matrix[i-1][j-1] + ((word1.charAt(i) == word2.charAt(j)) ? 0 : 1);
                
                matrix[i][j] = Math.min(diag, Math.min(left, up));
            }
        }
        return matrix[length1-1][length2-1];
    }
}