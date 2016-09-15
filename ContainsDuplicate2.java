public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i=0; i<length; i++) {
            Integer index = map.get(nums[i]);
            int diff = (index == null) ? Integer.MAX_VALUE : (i - index);
            if(diff <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}