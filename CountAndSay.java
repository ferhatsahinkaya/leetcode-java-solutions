public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i=1; i<n; i++) {
            result = getNext(result);
        }
        return result;
    }
    private String getNext(String value) {
        int length = value.length();
        int i = 0;
        String nextValue = "";
        while(i < length) {
            char digit = value.charAt(i);
            int count = 0;
            while((i < length) && (digit == value.charAt(i))) {
                i++;
                count++;
            }
            nextValue += String.format("%d%c", count, digit);
        }
        return nextValue;
    }
}