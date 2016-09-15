public class Solution {
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int prev = 1;
        int current = 2;

        while(n > 2) {
            int oldCurrent = current;
            current = current + prev;
            prev = oldCurrent;
            n--;
        }
        return current;
    }
}