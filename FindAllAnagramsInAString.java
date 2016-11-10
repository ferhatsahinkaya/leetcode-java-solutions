public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        
        int pCount = 0;
        for(char ch : p.toCharArray()) {
            counts[ch-'a']++;
            if(1 == counts[ch-'a']) pCount++;
        }
        
        int pLength = p.length();
        int sLength = s.length();
        
        List<Integer> anagrams = new ArrayList<>();
        int start = 0;
        int end = -1;
        while(end < sLength) {
            if(pCount == 0) {
                counts[s.charAt(start)-'a']++;
                if(counts[s.charAt(start)-'a'] == 1) pCount++;
                start++;
            } else {
                end++;
                if(end >= sLength) break;
                counts[s.charAt(end)-'a']--;
                if(counts[s.charAt(end)-'a'] == 0) pCount--;
            }
            
            if((pCount == 0) && (end-start+1 == pLength)) {
                anagrams.add(start);
            }
        }
        return anagrams;
    }
}