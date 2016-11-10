public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) x = 1/x;
        long longN = Math.abs((long) n);
        
        if(longN % 2 > 0) {
            return x * myPow(x, (int) (longN-1));
        }
        return myPow(x * x, (int) (longN/2));
    }
}