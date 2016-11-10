public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        long i = 0;
        long longNum = num;
        int step = 1;
        
        while(step >= 1) {
            if(i*i == longNum) return true;
            if(i*i < longNum) {
                i += step;
                step <<= 1;
            } else {
                step >>= 1;
                i -= step;
                step >>= 1;
            }
        }
        return false;
    }
}