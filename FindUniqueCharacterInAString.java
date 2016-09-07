public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for(int i=0; i<length; i++) {
            Integer count = map.get(s.charAt(i));
            count = (count != null) ? count : 0;
            map.put(s.charAt(i), count+1);
        }
        for(int i=0; i<length; i++) {
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}