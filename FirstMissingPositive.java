public class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<length; i++) {
            if(nums[i] <= 0) continue;
            Integer value = map.get(nums[i]);
            if(value == null) {
                map.put(nums[i], 1);
                merge(map, nums[i], nums[i]+1);
                merge(map, nums[i]-1, nums[i]);
            }
        }
        Integer firstGroupLength = map.get(1);
        firstGroupLength = (firstGroupLength != null) ? firstGroupLength : 0;
        return 1 + firstGroupLength;
    }
    private void merge(Map<Integer, Integer> map, int left, int right) {
        int start = (map.get(left) != null) ? left - map.get(left) + 1 : right;
        int end = (map.get(right) != null) ? right + map.get(right) - 1 : left;
        int length = end-start+1;
        map.put(start, length);
        map.put(end, length);
    }
}