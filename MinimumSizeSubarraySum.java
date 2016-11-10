public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int start = 0;
        int end = -1;
        
        boolean found = false;
        int minLength = Integer.MAX_VALUE;
        int current = 0;
        while(end < length) {
            if(current < s) {
                if(++end >= length) break;
                current += nums[end];
            } else {
                current -= nums[start++];
            }
            
            if(current >= s) {
                minLength = Math.min(minLength, end - start + 1);
                found = true;
            }
        }
        return found ? minLength : 0;
    }
}