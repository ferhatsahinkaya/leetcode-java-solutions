public class Solution {
    public int maximumGap(int[] nums) {
        int length = nums.length;
        sort(nums, 0, length-1, 31);
        
        int maxDiff = 0;
        for(int i=1; i<length; i++) {
            maxDiff = Math.max(maxDiff, nums[i] - nums[i-1]);
        }
        return maxDiff;
    }
    private void sort(int[] nums, int start, int end, int bitIndex) {
        if(start >= end || bitIndex < 0) return;
        int lastZero = start-1;
        for(int i=start; i<=end; i++) {
            if(!isSet(nums[i], bitIndex)) {
                swap(nums, ++lastZero, i);
            }
        }
        sort(nums, start, lastZero, bitIndex-1);
        sort(nums, lastZero+1, end, bitIndex-1);
    }
    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    private boolean isSet(int value, int bitIndex) {
        return (value & (1 << bitIndex)) != 0;
    }
}