public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, candidates.length-1, target, new ArrayList<>(), combinations);
        return combinations;
    }
    private void combinationSum(int[] candidates, int start, int end, int target, List<Integer> current, List<List<Integer>> combinations) {
        if(start > end) return;
        if(candidates[start] > target) return;
        if(candidates[start] == target) {
            List<Integer> newCombination = new ArrayList<>(current);
            newCombination.add(candidates[start]);
            combinations.add(newCombination);
        } else {
            int value = candidates[start];
            List<Integer> added = new ArrayList<>(current);
            added.add(value);
            combinationSum(candidates, start, end, target - value, added, combinations);
            combinationSum(candidates, start+1, end, target, current, combinations);
        }
    }
}