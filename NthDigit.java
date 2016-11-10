public class Solution {
    public int findNthDigit(int n) {
        long power = 1;
        int numDigits = 1;
        while(n > 0) {
            long digitCount = numDigits * (10 * power - power);
            if(n > digitCount) {
                n -= digitCount;
            } else {
                n--;
                long number = power + (n / numDigits);
                int digitIndex = numDigits - (n % numDigits) - 1;
                return (int) getDigit(number, digitIndex);
            }
            power *= 10;
            numDigits++;
        }
        return -1;
    }
    private int getDigit(long value, int digitIndex) {
        for(int i=0; i<digitIndex; i++, value/=10);
        return (int) (value % 10);
    }
}