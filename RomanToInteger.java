public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        initializeValueMap(map);
        
        int total = 0;
        int length = s.length();
        for(int i=0; i<length; i++) {
            int value = map.get(s.charAt(i));
            int nextValue = (i+1 < length) ? map.get(s.charAt(i+1)) : 0;
            
            total += (value >= nextValue) ? value : -value;
        }
        return total;
    }
    private static void initializeValueMap(Map<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}