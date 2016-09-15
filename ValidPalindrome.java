public class Solution {
    public boolean isPalindrome(String s) {
        int length = s.length();
        int start = getNextAlphaNumericIndex(s, 0, length-1, 0, 1);
        int end = getNextAlphaNumericIndex(s, 0, length-1, length-1, -1);
        while(start < end) {
            if(!isEqual(s.charAt(start), s.charAt(end))) return false;
            start = getNextAlphaNumericIndex(s, 0, length-1, start+1, 1);
            end = getNextAlphaNumericIndex(s, 0, length-1, end-1, -1);
        }
        return true;
    }
    private int getNextAlphaNumericIndex(String s, int start, int end, int runner, int increment) {
        while(runner >= start && runner <= end) {
            if(isAlphaNumeric(s.charAt(runner))) return runner;
            runner += increment;
        }
        return runner;
    }
    private boolean isAlphaNumeric(char ch) {
        return (ch >= 'a' && 'z' >= ch)
                || (ch >= 'A' && 'Z' >= ch)
                || (ch >= '0' && '9' >= ch);
    }
    private boolean isEqual(char ch1, char ch2) {
        return toLowerCase(ch1) == toLowerCase(ch2);
    }
    private char toLowerCase(char ch) {
        if(ch >= 'A' && 'Z' >= ch) return (char) (ch - 'A' + 'a');
        return ch;
    }
}