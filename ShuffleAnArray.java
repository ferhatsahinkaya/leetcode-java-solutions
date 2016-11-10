public class Solution {
    private int[] original;
    private int[] shuffled;
    
    public Solution(int[] nums) {
        original = nums;
        
        int length = nums.length;
        shuffled = new int[length];
        for(int i=0; i<length; i++) {
            shuffled[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        int length = shuffled.length;
        
        for(int i=0; i<length; i++) {
            int index = random.nextInt(length-i);
            swap(shuffled, index, length-i-1);
        }
        return shuffled;
    }
    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */