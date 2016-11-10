public class Solution {
    public String reverseWords(String s) {
        String value = s.trim();
        int length = value.length();
        if(length <= 0) return value;
        
        char[] chars = value.toCharArray();
        reverse(chars, 0, length-1);
        
        String result = "";
        int i = 0;
        while(i < length) {
            if(isSpace(chars[i])) {
                i++;
            } else {
                int wordStart = i;
                while((i < length) && !isSpace(chars[i])) i++;
                int wordEnd = i-1;
                reverse(chars, wordStart, wordEnd);
                
                result += ((wordStart > 0) ? " " : "") 
                          + new String(chars, wordStart, wordEnd-wordStart+1);
            }
        }
        return result;
    }
    private void reverse(char[] chars, int start, int end) {
        while(start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            
            start++;
            end--;
        }
    }
    private boolean isSpace(char ch) {
        return ch == ' ';
    }
}