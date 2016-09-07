public class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int lastNonZero = -1;
        for(int i=0; i<length; i++) {
            if(nums[i] != 0) {
                swap(nums, ++lastNonZero, i);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}