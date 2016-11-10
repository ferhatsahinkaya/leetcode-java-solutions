public class Solution {
    public String toHex(int num) {
        String result = "";
        for(int i=0; i<8; i++) {
            int digitValue = filter(num, i);
            result = ((digitValue <= 9) ? String.valueOf(digitValue) : String.valueOf((char) ('a' + digitValue - 10))) + result;
        }
        int startIndex = 0;
        while((startIndex < result.length()) && (result.charAt(startIndex) == '0')) {
            startIndex++;
        }
        return (startIndex == result.length()) ? "0" : result.substring(startIndex, result.length());
    }
    private int filter(int n, int index) {
        return 15 & (n >> (index * 4)); 
    }
}