public class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if(length <= 0) return 0;
        
        int[] decodings = new int[length];
        decodings[0] = isSingleDigit(s.charAt(0)) ? 1 : 0;
        for(int i=1; i<length; i++) {
            decodings[i] = (isSingleDigit(s.charAt(i)) ? ((i >= 1) ? decodings[i-1] : 1) : 0) +
                           (isDoubleDigit(s.charAt(i-1), s.charAt(i)) ? ((i >= 2) ? decodings[i-2] : 1) : 0);
        }
        return decodings[length-1];
    }
    private boolean isSingleDigit(char ch) {
        return (ch >= '1' && ch <= '9');
    }
    private boolean isDoubleDigit(char ch1, char ch2) {
        return (ch1 == '1' && (ch2 >= '0' && ch2 <= '9'))
                || (ch1 == '2' && (ch2 >= '0' && ch2 <= '6'));
    }
}