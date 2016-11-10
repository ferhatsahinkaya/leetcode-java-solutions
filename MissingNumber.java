public class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        long totalWithMissing = (length * (length+1)) / 2;
        long totalWithoutMissing = 0;
        for(int i=0; i<length; i++) {
            totalWithoutMissing += nums[i];
        }
        return (int) (totalWithMissing - totalWithoutMissing);
    }
}