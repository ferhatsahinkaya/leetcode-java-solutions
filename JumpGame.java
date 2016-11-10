public class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if(length <= 1) return true;
        
        int maxJumpIndex = nums[0];
        if(maxJumpIndex >= length-1) return true;
        
        int i=0;
        while(i <= maxJumpIndex) {
            maxJumpIndex = Math.max(maxJumpIndex, i + nums[i]);
            if(maxJumpIndex >= length-1) return true;
            i++;
        }
        return false;
    }
}