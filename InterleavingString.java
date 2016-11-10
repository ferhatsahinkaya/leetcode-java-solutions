public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if(length1 + length2 != length3) return false;
        
        boolean[][] matrix = new boolean[length1+1][length2+1];
        matrix[0][0] = true;
        
        for(int i=1; i<=length1; i++) {
            matrix[i][0] = (s1.charAt(i-1) == s3.charAt(i-1)) && matrix[i-1][0];
        }
        for(int i=1; i<=length2; i++) {
            matrix[0][i] = (s2.charAt(i-1) == s3.charAt(i-1)) && matrix[0][i-1];
        }
        
        for(int i=1; i<=length1; i++) {
            for(int j=1; j<=length2; j++) {
                matrix[i][j] = (matrix[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1)))
                                || (matrix[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)));
            }
        }
        return matrix[length1][length2];
    }
}