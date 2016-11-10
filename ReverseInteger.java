public class Solution {
    public int reverse(int x) {
        boolean isNegative = (x < 0);
        long longX = Math.abs((long) x);
        long reverseX = 0;
        
        while(longX > 0) {
            long digit = longX % 10;
            reverseX = (reverseX * 10) + digit;
            longX /= 10;
        }
        
        reverseX = isNegative ? -reverseX : reverseX;
        if((reverseX > Integer.MAX_VALUE) || (reverseX < Integer.MIN_VALUE)) return 0;
        return (int) reverseX;
    }
}