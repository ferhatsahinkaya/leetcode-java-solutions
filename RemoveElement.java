public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int last = -1;
        for(int i=0; i<length; i++) {
            if(nums[i] != val) {
                nums[++last] = nums[i];
            }
        }
        return last+1;
    }
}