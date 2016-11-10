public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int length = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        int value = 0;
        for(int i=0; i<length; i++) {
            value = shift(value, getIntegerValue(s.charAt(i)));
            
            if(i >= 9) {
                Integer count = map.get(value);
                count = (count != null) ? count : 0;
                map.put(value, count+1);
            }
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) result.add(getStringValue(entry.getKey()));
        }
        return result;
    }
    private int shift(int n, int value) {
        return ((n << 2) | value) & ((1 << 20) - 1);
    }
    private String getStringValue(int n) {
        String value = "";
        for(int i=0; i<10; i++) {
            value = String.valueOf(getCharValue(n & 3)) + value;
            n >>= 2;
        }
        return value;
    }
    private char getCharValue(int n) {
        if(n <= 0) return 'A';
        if(n <= 1) return 'C';
        if(n <= 2) return 'G';
        return 'T';
    }
    private int getIntegerValue(char ch) {
        if(ch == 'A') return 0;
        if(ch == 'C') return 1;
        if(ch == 'G') return 2;
        return 3;
    }
}