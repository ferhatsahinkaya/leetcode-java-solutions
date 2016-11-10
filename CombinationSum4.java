public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return combinationSum(nums, target, map);
    }
    private int combinationSum(int[] nums, int target, Map<Integer, Integer> map) {
        if(nums.length == 0 || target < 0) return 0;
        if(target == 0) return 1;
        
        Integer count = map.get(target);
        if(count != null) return count;
        count = 0;
        for(int num : nums) {
            count += combinationSum(nums, target-num, map);
        }
        map.put(target, count);
        return count;
    }
}