public class Solution {
    public String reverseString(String s) {
        int end = s.length() - 1;
        int start = 0;
        if(start >= end) return s;
        
        char[] chars = s.toCharArray();
        while(start < end) {
            char ch = chars[start];
            chars[start] = chars[end];
            chars[end] = ch;
            
            start++;
            end--;
        }
        return new String(chars);
    }
}