public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length <= 0) return "";
        
        int maxLength = 1;
        int start = 0;
        int end = 0;
        
        for(int i=0; i + ((maxLength-1) / 2) < length; i++) {
            int currentLength = expand(s, 0, length-1, i-1, i+1);
            if(maxLength < currentLength) {
                start = i - (currentLength / 2);
                end = i + (currentLength / 2);
                maxLength = currentLength;
            }
            currentLength = expand(s, 0, length-1, i, i+1);
            if(maxLength < currentLength) {
                start = i - ((currentLength-1) / 2);
                end = i + (currentLength / 2);
                maxLength = currentLength;
            }
        }
        return s.substring(start, end+1);
    }
    private int expand(String s, int start, int end, int i, int j) {
        while((i >= start) && (j <= end) && (s.charAt(i) == s.charAt(j))) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}