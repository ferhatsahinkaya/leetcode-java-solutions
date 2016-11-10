public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        
        int maxLength = 0;
        int start = 0;
        int end = 0;
        while(end < length) {
            Integer endCount = map.get(s.charAt(end));
            endCount = (endCount != null) ? endCount : 0;
            
            if(endCount > 0) {
                int startCount = map.get(s.charAt(start));
                map.put(s.charAt(start), startCount-1);
                start++;
            } else {
                map.put(s.charAt(end), endCount + 1);
                maxLength = Math.max(maxLength, end-start+1);
                end++;
            }
        }
        return maxLength;
    }
}