public class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int lastLength = 0;
        
        int runner = length-1;
        while((runner >= 0) && (s.charAt(runner) == ' ')) {
            runner--;
        }
        
        while((runner >= 0) && (s.charAt(runner) != ' ')) {
            lastLength++;
            runner--;
        }
        
        return lastLength;
    }
}