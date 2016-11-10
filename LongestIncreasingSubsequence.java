public class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        
        int[] counts = new int[length];
        int maxLength = 0;
        for(int i=0; i<length; i++) {
            int previousLength = 0;
            for(int j=i-1; j>=0; j--) {
                if(nums[i] > nums[j]) {
                    previousLength = Math.max(previousLength, counts[j]);
                }
            }
            counts[i] = previousLength+1;
            maxLength = Math.max(maxLength, counts[i]);
        }
        return maxLength;
    }
}