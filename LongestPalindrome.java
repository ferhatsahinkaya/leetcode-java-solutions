public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            Integer count = map.get(ch);
            count = (count != null) ? count : 0;
            map.put(ch, count+1);
        }
        int length = 0;
        boolean hasOddCount = false;
        for(int count : map.values()) {
            if(count % 2 == 0) {
                length += count;
            } else {
                length += count-1;
                hasOddCount = true;
            }
        }
        return length + (hasOddCount ? 1 : 0);
    }
}