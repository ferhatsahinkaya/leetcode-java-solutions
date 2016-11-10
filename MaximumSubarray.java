public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if(length <= 0) return 0;
        int total = nums[0];
        int maxTotal = nums[0];
        
        for(int i=1; i<length; i++) {
            if(nums[i] > total + nums[i]) {
                total = nums[i];
            } else {
                total += nums[i];
            }
            maxTotal = Math.max(maxTotal, total);
        }
        return maxTotal;
    }
}