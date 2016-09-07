public class Solution {
    public char findTheDifference(String s, String t) {
        int[] sMap = new int[26];
        Arrays.fill(sMap, 0);
        for(char ch : s.toCharArray()) {
            sMap[ch - 'a']++;
        }
        for(char ch : t.toCharArray()) {
            sMap[ch - 'a']--;
            if(sMap[ch - 'a'] < 0) return ch;
        }
        return '0';
    }
}