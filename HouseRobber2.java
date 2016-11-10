public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length <= 0) return 0;
        
        int[] withFirst = new int[length];
        int[] withoutFirst = new int[length];
        
        withFirst[0] = nums[0];
        withoutFirst[0] = 0;
        for(int i=1; i<length; i++) {
            withFirst[i] = (i != length-1) 
                            ? Math.max(withFirst[i-1], nums[i] + ((i >= 2) ? withFirst[i-2] : 0))
                            : withFirst[i-1];
            withoutFirst[i] = Math.max(withoutFirst[i-1], nums[i] + ((i >= 2) ? withoutFirst[i-2] : 0));
        }
        return Math.max(withoutFirst[length-1], withFirst[length-1]);
    }
}