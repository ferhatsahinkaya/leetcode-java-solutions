public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, candidates.length-1, target, new ArrayList<>(), result);
        return result;
    }
    private void combinationSum(int[] candidates, int start, int end, int target, List<Integer> current, List<List<Integer>> combinations) {
        if(target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        if(start > end) return;
        if(candidates[start] > target) return;

        int value = candidates[start];        
        List<Integer> newCurrent = new ArrayList<>(current);
        newCurrent.add(value);
        combinationSum(candidates, start+1, end, target-value, newCurrent, combinations);

        while((start <= end) && (value == candidates[start])) start++;
        combinationSum(candidates, start, end, target, current, combinations);
    }
}