public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        
        int[] result = new int[2];
        result[0] = find(nums, start, end, target, false);
        result[1] = find(nums, start, end, target, true);
        return result;
    }
    private int find(int[] nums, int start, int end, int target, boolean right) {
        int index = -1;
        while(start <= end) {
            int mid = start + ((end - start) / 2);
            if(nums[mid] == target) {
                index = mid;
                if(right) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else if(nums[mid] < target) {
                start = mid+1;
            } else if(nums[mid] > target) {
                end = mid-1;
            }
        }
        return index;
    }
}