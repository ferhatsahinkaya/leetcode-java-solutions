public class Solution {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<length; i++) {
            Set<Integer> nextSet = new HashSet<>();
            if(!set.isEmpty()) {
                for(int value : set) {
                    nextSet.add(value + nums[i]);
                    nextSet.add(value - nums[i]);
                }
            } else {
                nextSet.add(nums[i]);
                nextSet.add(nums[i]);
            }
            set = nextSet;
        }
        return set.contains(0);
    }
}