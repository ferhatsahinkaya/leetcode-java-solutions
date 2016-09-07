public class Solution {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        int number = 0;
        for(int i=0; i<length; i++) {
            number = number ^ nums[i];
        }
        return number;
    }
}