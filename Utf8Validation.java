public class Solution {
    public boolean validUtf8(int[] data) {
        int length = data.length;
        if(length <= 0) return false;
        
        for(int i=0; i<length; ) {
            int byteCount = getByteCount(data[i]);
            if((byteCount > 4) || (byteCount == 1)) return false;
            int j=1;
            while(j<byteCount) {
                if(i+j >= length) return false;
                if(!isValidContinuation(data[i+j])) return false;
                j++;
            }
            i+=j;
        }
        return true;
    }
    private boolean isValidContinuation(int value) {
        return (value >> 6) == 2;
    }
    private int getByteCount(int value) {
        int mask = 1 << 7;
        int count = 0;
        while((mask & value) != 0) {
            mask >>= 1;
            count++;
        }
        return count;
    }
}