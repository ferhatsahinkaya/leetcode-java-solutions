public class Solution {
    public int minMoves(int[] nums) {
        int length = nums.length;
        if(length <= 1) return 0;
        
        long sum = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i=0; i<length; i++) {
            minValue = Math.min(minValue, nums[i]);
            sum += nums[i];
        }
        return (int) (sum - (minValue * length));
    }
}