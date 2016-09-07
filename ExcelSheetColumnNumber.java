public class Solution {
    public int titleToNumber(String s) {
        int length = s.length();
        int value = 0;
        for(int i=0; i<length; i++) {
            int digit = getDigitValue(s.charAt(i));
            value = value * 26 + digit;
        }
        return value;
    }
    private int getDigitValue(char ch) {
        return ch - 'A' + 1;
    }
}