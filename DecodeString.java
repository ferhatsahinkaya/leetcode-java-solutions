public class Solution {
    public String decodeString(String s) {
        return decodeString(s, 0, s.length()-1);
    }
    private String decodeString(String s, int start, int end) {
        String decoded = "";
        if(start > end) return decoded;
        
        boolean digitFound = false;
        boolean hasOpening = false;
        int i=start;
        int count = 1;
        while(i <= end) {
            if(isDigit(s.charAt(i))) {
                if((i > start) && !digitFound) {
                    break;
                }
                digitFound = true;
            }
            if(isOpening(s.charAt(i))) {
                hasOpening = true;
                
                int closingIndex = getClosingIndex(s, i+1, end);
                decoded = decodeString(s, i+1, closingIndex-1);
                count = Integer.parseInt(s.substring(start, i));
                i = closingIndex+1;
                break;
            }
            i++;
        }
        if(!hasOpening) decoded = s.substring(start, i);
        
        String result = "";
        for(int j=0; j<count; j++) {
            result += decoded;
        }
        return result + decodeString(s, i, end);
    }
    private int getClosingIndex(String s, int start, int end) {
        int depth = 1;
        for(int i=start; i<=end; i++) {
            if(isOpening(s.charAt(i))) depth++;
            if(isClosing(s.charAt(i))) {
                depth--;
                if(depth == 0) return i;
            } 
        }
        return -1;
    }
    private boolean isDigit(char ch) {
        return (ch >= '0' && '9' >= ch);
    }
    private boolean isClosing(char ch) {
        return ch == ']';
    }
    private boolean isOpening(char ch) {
        return ch == '[';
    }
}