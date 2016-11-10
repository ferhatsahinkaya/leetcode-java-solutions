public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, nums.length-1, subsets);
        return subsets;
    }
    private void subsetsWithDup(int[] nums, int start, int end, List<List<Integer>> subsets) {
        if(start > end) {
            subsets.add(new ArrayList<>());
        } else {
            subsetsWithDup(nums, start, end-1, subsets);
            int subsetCount = subsets.size();
            for(int i=0; i<subsetCount; i++) {
                List<Integer> newSubset = new ArrayList<>(subsets.get(i));
                newSubset.add(nums[end]);
                if(!subsets.contains(newSubset)) {
                    subsets.add(newSubset);
                }
            }
        }
    }
}