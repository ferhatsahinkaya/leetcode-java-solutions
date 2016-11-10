public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> permutations = new LinkedList<>();
        permute(nums, 0, nums.length-1, permutations);
        return permutations;
    }
    private void permute(int[] nums, int start, int end, LinkedList<List<Integer>> permutations) {
        if(start > end) return;
        if(start == end) {
            List<Integer> permutation = new ArrayList<>();
            permutation.add(nums[start]);
            permutations.add(permutation);
            return;
        }
        permute(nums, start+1, end, permutations);
        int permutationCount = permutations.size();
        for(int i=0; i<permutationCount; i++) {
            List<Integer> permutation = permutations.removeFirst();
            int permutationSize = permutation.size();
            for(int j=0; j<=permutationSize; j++) {
                List<Integer> newPermutation = new ArrayList<>();
                for(int k=0; k<j; k++) {
                    newPermutation.add(permutation.get(k));
                }
                newPermutation.add(nums[start]);
                for(int k=j; k<permutationSize; k++) {
                    newPermutation.add(permutation.get(k));
                }
                permutations.add(newPermutation);
            }
        }
    }
}