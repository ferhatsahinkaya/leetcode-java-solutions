public class Solution {
    public int[] singleNumber(int[] nums) {
        int length = nums.length;
        int diff = 0;
        
        for(int i=0; i<length; i++) {
            diff ^= nums[i];
        }
        
        int[] result = new int[2];
        int setBitIndex = getSetBitIndex(diff);
        for(int i=0; i<length; i++) {
            if(getBitValue(nums[i], setBitIndex) != 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }
    private int getBitValue(int value, int index) {
        return ((value & (1 << index)) != 0) ? 1 : 0;
    }
    private int getSetBitIndex(int value) {
        for(int i=0; i<32; i++) {
            if(getBitValue(value, i) != 0) return i;
        }
        return -1;
    }
}