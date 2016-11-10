public class Solution {
    public int integerBreak(int n) {
        if(n <= 1) return 0;
        if(n <= 2) return 1;
        if(n <= 3) return 2;
        if(n <= 4) return 4;
        
        int value = 4;
        int base = 1;
        int mod = 0;
        for(int i=4; i<n; i++) {
            if(mod % 4 == 0)  {
                value += 2 * base;
                mod++;
            } else if(mod % 4 <= 2) { 
                value += 3 * base;
                mod++;
            } else {
                base *= 3;
                value += 2 * base;
                mod = 1;
            }
        }
        return value;
    }
}