public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        sort(nums, 0, length-1, 31);
        for(int i=1; i<length; i++) {
            if(nums[i] == nums[i-1]) {
                result.add(nums[i]);
            }
        }
        return result;
    }
    private void sort(int[] nums, int start, int end, int bitIndex) {
        if(start >= end) return;
        if(bitIndex < 0) return;
        
        int lastZero = start-1;
        for(int i=start; i<=end; i++) {
            if(isZero(nums[i], bitIndex)) {
                swap(nums, ++lastZero, i);
            }
        }
        sort(nums, start, lastZero, bitIndex-1);
        sort(nums, lastZero+1, end, bitIndex-1);
    }
    private boolean isZero(int value, int bitIndex) {
        return ((value & (1 << bitIndex)) == 0);
    }
    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}