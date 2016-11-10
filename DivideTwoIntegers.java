public class Solution {
    public int divide(int dividend, int divisor) {
        long ldividend = dividend;
        long ldivisor = divisor;
        boolean isNegative = (ldividend > 0 && ldivisor < 0) || (ldividend < 0 && ldivisor > 0);

        ldividend = (ldividend >= 0) ? ldividend : -ldividend;
        ldivisor = (ldivisor >= 0) ? ldivisor : -ldivisor;
        
        long step = 1;
        long division = 0;
        while(step >= 1) {
            if(ldividend >= ldivisor) {
                ldividend -= ldivisor;
                
                division += step;
                step <<= 1;
                ldivisor <<= 1;
            } else {
                step >>= 1;
                ldivisor >>= 1;
            }
        }
        division = isNegative ? -division : division;
        if((division >= Integer.MAX_VALUE) || (division < Integer.MIN_VALUE)) return Integer.MAX_VALUE;
        return (int) division;
    }
}