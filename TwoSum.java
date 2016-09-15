public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<length; i++) {
            map.put(nums[i], i);
        }

        int[] result = new int[2];
        for(int i=0; i<length; i++) {
            Integer complement = map.get(target - nums[i]);
            if((complement != null) && (complement != i)) {
                result[0] = Math.min(complement, i);
                result[1] = Math.max(complement, i);
                break;
            }
        }
        return result;
    }
}