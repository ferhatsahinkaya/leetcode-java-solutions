public class Solution {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        
        int slow = 0;
        int fast = 0;
        do {
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];
        } while(slow != fast);
        
        fast = 0;
        while(slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}