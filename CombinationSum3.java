public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum(k, n, 1, 9, combinations, new ArrayList<>());
        return combinations;
    }
    private void combinationSum(int count, int target, int start, int end, List<List<Integer>> combinations, List<Integer> current) {
        if(count == 0) {
            if(target == 0) combinations.add(new ArrayList<>(current));
            return;
        }
        if(start > target) return;
        if(start > end) return;
        combinationSum(count, target, start+1, end, combinations, current);
        
        List<Integer> newCurrent = new ArrayList<>(current);
        newCurrent.add(start);
        combinationSum(count-1, target-start, start+1, end, combinations, newCurrent);
    }
}