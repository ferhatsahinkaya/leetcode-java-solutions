public class Solution {
    public int removeDuplicates(int[] nums) {
        int last = -1;
        int k = 2;
        int length = nums.length;
        for(int i=0; i<length; ) {
            int value = nums[i];
            int count = 0;
            while((i < length) && (nums[i] == value)) {
                if(count < k) {
                    nums[++last] = nums[i];
                    count++;
                }
                i++;
            }
        }
        return last+1;
    }
}