public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if(length <= 1) return length;
        
        int[] increasing = new int[length];
        Arrays.fill(increasing, 1);
        
        int[] decreasing = new int[length];
        Arrays.fill(decreasing, 1);
        
        int maxLength = 1;
        for(int i=1; i<length; i++) {
            for(int j=0; j<i; j++) {
                increasing[i] = (nums[i] > nums[j]) ? Math.max(increasing[i], decreasing[j]+1) : increasing[i];
                decreasing[i] = (nums[i] < nums[j]) ? Math.max(decreasing[i], increasing[j]+1) : decreasing[i];
            }
            maxLength = Math.max(maxLength, Math.max(increasing[i], decreasing[i]));
        }
        return maxLength;
    }
}