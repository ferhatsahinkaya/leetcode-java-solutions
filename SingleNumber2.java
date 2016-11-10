public class Solution {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        
        int value = 0;
        for(int i=0; i<32; i++) {
            int oneCount = 0;
            for(int j=0; j<length; j++) {
                oneCount += getBit(nums[j], i);
            }
            if(oneCount % 3 == 1) {
                value |= (1 << i);
            }
        }
        return value;
    }
    private int getBit(int value, int bitIndex) {
        return ((value & (1 << bitIndex)) == 0) ? 0 : 1;
    }
}