public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int total = 0;
        for(int i=0; i<=n; i++) {
            total += getCount(i);
        }
        return total;
    }
    private int getCount(int n) {
        int total = 1;
        int valueCount = 9;
        for(int i=0; (i < n) && (valueCount > 0); i++) {
            if(i == 0) total *= valueCount;
            else {
                total *= valueCount--;
            }
        }
        return total;
    }
}