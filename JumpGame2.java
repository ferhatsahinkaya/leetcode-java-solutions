public class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        if(length <= 1) return 0;
        
        int maxJumpIndex = 0;
        int step = 1;
        int i = 0;
        while(i < length) {
            int nextMaxJumpIndex = maxJumpIndex;
            while(i <= maxJumpIndex) {
                nextMaxJumpIndex = Math.max(nextMaxJumpIndex, nums[i] + i);
                if(nextMaxJumpIndex >= length-1) return step;
                i++;
            }
            maxJumpIndex = nextMaxJumpIndex;
            step++;
        }
        return -1;
    }
}