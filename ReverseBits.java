public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int start = 0;
        int end = 31;
        
        while(start < end) {
            n = swap(n, start++, end--);
        }
        return n;
    }
    private int swap(int n, int i, int j) {
        int tmp = getBit(n, i);
        n = setBit(n, i, getBit(n, j));
        return setBit(n, j, tmp);
    }
    private int getBit(int n, int i) {
        return ((n & (1 << i)) != 0) ? 1 : 0;
    }
    private int setBit(int n, int i, int newValue) {
        return (n & (~(1 << i))) | (newValue << i);
    }
}