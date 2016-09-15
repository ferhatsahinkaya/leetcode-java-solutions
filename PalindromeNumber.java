public class Solution {
    public boolean isPalindrome(int n) {
        if(n < 0) return false;
        
        while(n > 9) {
            int power = getPower(n);
            int leftMost = n / power;
            int rightMost = n % 10;
            if(leftMost != rightMost) return false;
            
            int remaining = n % power;
            int remPower = getPower(remaining);
            remaining /= 10;

            int diffPower = power / remPower;
            while(diffPower > 10) {
                if(remaining % 10 != 0) return false;
                remaining /= 10;
                
                diffPower /= 10;
            }
            n = remaining;
        }
        return true;
    }
    private int getPower(int n) {
        int power = 1;
        while(n > 9) {
            n /= 10;
            power *= 10;
        }
        return power;
    }
}