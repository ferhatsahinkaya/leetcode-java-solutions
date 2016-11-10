public class Solution {
    public int[] findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        int length = nums.length;
        if(length <= 0) return new int[0];
        
        sort(nums, 0, length-1, 31);
        for(int i=0; i<=length; i++) {
            if(i == length) {
                for(int j=nums[i-1]+1; j<=length; j++) {
                    missing.add(j);
                }
            } else if(i > 0) {
                for(int j=nums[i-1]+1; j<nums[i]; j++) {
                    missing.add(j);
                }
            } else {
                for(int j=1; j<nums[0]; j++) {
                    missing.add(j);
                }
            }
        }
        int missingCount = missing.size();
        int[] missingArray = new int[missingCount];
        for(int i=0; i<missingCount; i++) {
            missingArray[i] = missing.get(i);
        }
        return missingArray;
    }
    private void sort(int[] nums, int start, int end, int bitIndex) {
        if(start >= end) return;
        if(bitIndex < 0) return;
        
        int lastZero=start-1;
        for(int i=start; i<=end; i++) {
            if(!isSet(nums[i], bitIndex)) {
                swap(nums, ++lastZero, i);
            }
        }
        sort(nums, start, lastZero, bitIndex-1);
        sort(nums, lastZero+1, end, bitIndex-1);
    }
    private boolean isSet(int value, int index) {
        return (value & (1 << index)) != 0;
    }
    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}