public class Solution {
    public String reverseVowels(String s) {
        int length = s.length();
        
        char[] chars = s.toCharArray();
        int start = getNextVowelIndex(chars, 0, length-1, 0, 1);
        int end = getNextVowelIndex(chars, 0, length-1, length-1, -1);
        
        while(start < end) {
            swap(chars, start, end);
            start = getNextVowelIndex(chars, start+1, end-1, start+1, 1);
            end = getNextVowelIndex(chars, start+1, end-1, end-1, -1);
        }
        return new String(chars);
    }
    private int getNextVowelIndex(char[] chars, int start, int end, int i, int increment) {
        while(start <= i && i <= end) {
            if(isVowel(chars[i])) return i; 
            i += increment;
        }
        return i;
    }
    private boolean isVowel(char ch) {
        return "AEIUOaeiuo".indexOf(ch) >= 0;
    }
    private void swap(char[] chars, int i, int j) {
        if(i != j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
}