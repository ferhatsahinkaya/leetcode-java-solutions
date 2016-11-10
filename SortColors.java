public class Solution {
    public void sortColors(int[] nums) {
        int lastZero = -1;
        int lastTwo = nums.length;
        
        int i = 0;
        while(i < lastTwo) {
            if(nums[i] == 2) {
                swap(nums, i, --lastTwo);
            } else if(nums[i] == 0) {
                swap(nums, ++lastZero, i);
                i = Math.max(lastZero+1, i);
            } else {
                i++;
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