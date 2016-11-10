public class Solution {
    private final Map<Integer, List<Integer>> map = new HashMap<>();

    public Solution(int[] nums) {
        int length = nums.length;
        for(int i=0; i<length; i++) {
            List<Integer> list = map.get(nums[i]);
            list = (list != null) ? list : new ArrayList<>();
            list.add(i);
            map.put(nums[i], list);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */