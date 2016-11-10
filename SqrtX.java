public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return x;
        
        long sqrt = 0;
        int step = 1;
        while(step > 0) {
            long value = sqrt * sqrt;
            if(value == x) break;
            if(value < x) {
                sqrt += step;
                step <<= 1;
            } else {
                step >>= 1;
                sqrt -= step;
                step >>= 1;
            }
        }
        return (int) sqrt;
    }
}