public class Solution {
    public int arrangeCoins(int n) {
        long step = 1;
        long i=0;
        long longN = n;
        while(i <= longN) {
            i += step;
            if(i <= longN) {
                step++;
            }
        }
        return (int) (step-1);
    }
}