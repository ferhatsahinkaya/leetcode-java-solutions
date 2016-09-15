public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length <= 0) return 0;
        if(length <= 1) return nums[0];
        if(length <= 2) return Math.max(nums[0], nums[1]);
        
        int maxRob = nums[0];
        int[] withIndex = new int[length];
        withIndex[0] = nums[0];
        int[] withoutIndex = new int[length];
        withoutIndex[0] = 0;
        for(int i=1; i<length; i++) {
            withIndex[i] = nums[i] + withoutIndex[i-1];
            withoutIndex[i] = Math.max(withIndex[i-1], withoutIndex[i-1]);
            maxRob = Math.max(maxRob, Math.max(withIndex[i], withoutIndex[i]));
        }
        return maxRob;
    }
}