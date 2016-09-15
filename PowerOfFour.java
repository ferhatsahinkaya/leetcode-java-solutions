public class Solution {
    public boolean isPowerOfFour(int num) {
        return (num > 0)
                && ((num & (num-1)) == 0)
                && hasEvenNumberOfZeroes(num);
    }
    private boolean hasEvenNumberOfZeroes(int num) {
        int count = 0;
        for(int i=0; i<32; i++) {
            if(((1 << i) & num) == 0) count++;
            else break;
        }
        return count % 2 == 0;
    }
}