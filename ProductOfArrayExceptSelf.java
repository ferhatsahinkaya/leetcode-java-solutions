public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        Arrays.fill(left, 1);
        int[] right = new int[length];
        Arrays.fill(right, 1);
        
        for(int i=1; i<length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        for(int i=length-2; i>=0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        int[] result = new int[length];
        for(int i=0; i<length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}