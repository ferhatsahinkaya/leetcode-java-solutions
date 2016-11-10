public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        return increasing(nums, 0, length-1, Integer.MIN_VALUE, 3);
    }
    private boolean increasing(int[] nums, int start, int end, int first, int count) {
        if(count == 0) return true;
        int min = Integer.MAX_VALUE;
        boolean found = false;
        for(int i=start; i<=end && !found; i++) {
            if(nums[i] <= first) continue;
            
            min = Math.min(min, nums[i]);
            found = increasing(nums, i+1, end, min, count-1);
        }
        return found;
    }
}