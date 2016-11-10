public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i=0; i<=num; i++) {
            result[i] = getSetBitCount(i);
        }
        return result;
    }
    private int getSetBitCount(int value) {
        int count = 0;
        while(value != 0) {
            value = (value & (value-1));
            count++;
        }
        return count;
    }
}