public class Solution {
    public String minWindow(String s, String t) {
        int tLength = t.length();
        if(tLength <= 0) return "";
        
        int sLength = s.length();
        if(sLength <= 0) return "";
        
        Map<Character, Integer> tMap = new HashMap<>();
        int tCount = 0;
        for(int i=0; i<tLength; i++) {
            Integer count = tMap.get(t.charAt(i));
            count = (count != null) ? count : 0;
            tCount += (count == 0) ? 1 : 0;
            tMap.put(t.charAt(i), count+1);
        }
        
        int minStart = 0;
        int minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        
        int start = 0;
        int end = 0;
        while(end <= sLength) {
            if(tCount > 0) {
                if(end >= sLength) break;
                
                Integer count = tMap.get(s.charAt(end));
                if(count == null) {
                    end++;
                    continue;
                }
                
                count--;
                if(count == 0) tCount--;
                tMap.put(s.charAt(end), count);
                end++;
            } else {
                Integer count = tMap.get(s.charAt(start));
                if(count != null) {
                   count++;
                   if(count == 1) tCount++;
                   tMap.put(s.charAt(start), count);
                }
                start++;
            }
            
            if(tCount == 0) {
                int length = end-start;
                if(length < minLength) {
                    minLength = length;
                    minStart = start;
                    minEnd = end;
                }
            }
        }
        return s.substring(minStart, minEnd);
    }
}