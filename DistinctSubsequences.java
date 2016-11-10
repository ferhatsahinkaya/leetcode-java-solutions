public class Solution {
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(sLength < tLength) return 0;
        if(sLength == 0 || tLength == 0) return 0;
        
        int[][] matrix = new int[sLength][tLength];
        matrix[0][0] = (s.charAt(0) == t.charAt(0)) ? 1 : 0;
        for(int i=1; i<sLength; i++) {
            matrix[i][0] = matrix[i-1][0] + ((s.charAt(i) == t.charAt(0)) ? 1 : 0);
        }
        for(int i=1; i<tLength; i++) {
            matrix[0][i] = 0;
        }
        for(int i=1; i<sLength; i++) {
            for(int j=1; j<tLength; j++) {
                matrix[i][j] = matrix[i-1][j] + ((s.charAt(i) == t.charAt(j)) ? matrix[i-1][j-1] : 0);
            } 
        }
        return matrix[sLength-1][tLength-1];
    }
}