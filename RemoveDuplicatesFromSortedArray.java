public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        
        int last = -1;
        int i = 0;
        while(i < length) {
            int val = nums[i++];
            nums[++last] = val;
            while((i < length) && (nums[i] == val)) {
                i++;
            }
        }
        return last+1;
    }
}