public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        subsets(nums, 0, nums.length-1, subsetList);
        return subsetList;
    }
    private void subsets(int[] nums, int start, int end, List<List<Integer>> subsetList) {
        if(start > end) {
            subsetList.add(new ArrayList<>());
        } else {
            subsets(nums, start+1, end, subsetList);
            int subsetCount = subsetList.size();
            for(int i=0; i<subsetCount; i++) {
                List<Integer> newSubset = new ArrayList<>(subsetList.get(i));
                newSubset.add(nums[start]);
                subsetList.add(newSubset);
            }
        }
    }
}