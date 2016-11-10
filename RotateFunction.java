public class Solution {
    public int maxRotateFunction(int[] A) {
        int length = A.length;
        if(length <= 1) return 0;
        
        long total = 0;
        for(int i=0; i<length; i++) {
            total += A[i];
        }
        
        long current = calculate(A, 0, length);
        
        long maxValue = current;
        for(int i=1; i<length; i++) {
            current = current - total + (A[i-1] * length);
            maxValue = Math.max(maxValue, current);
        }
        return (int) maxValue;
    }
    private long calculate(int[] A, int start, int length) {
        long value = 0;
        for(int i=0; i<length; i++) {
            value += (A[(start + i) % length] * i);
        }
        return value;
    }
}