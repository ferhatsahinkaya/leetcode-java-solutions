public class Solution {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if(length <= 0) return -1;
        
        int start = 0;
        int end = length-1;
        while(start <= end) {
            int mid = start + ((end-start) / 2);
            if(isPeak(nums, 0, length-1, mid)) {
                return mid;
            } else if(shouldMoveRight(nums, 0, length-1, mid)) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
    private boolean isPeak(int[] nums, int start, int end, int index) {
        boolean greaterThanLeft = (start >= index) || (nums[index-1] < nums[index]);
        boolean greaterThanRight = (index >= end) || (nums[index+1] < nums[index]);
        return greaterThanLeft && greaterThanRight;
    }
    private boolean shouldMoveRight(int[] nums, int start, int end, int index) {
        return (start >= index) || (nums[index-1] < nums[index]);
    }
}