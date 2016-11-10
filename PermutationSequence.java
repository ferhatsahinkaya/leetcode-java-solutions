public class Solution {
    public String getPermutation(int n, int k) {
        int permutationCount = factorial(n);
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        
        return getPermutation(permutationCount, k-1, n, used, n);
    }
    private String getPermutation(int permutationCount, int permutationIndex, int length, boolean[] used, int usedSize) {
        if(length <= 0) return "";
        
        int groupSize = permutationCount / length;
        int groupIndex = permutationIndex / groupSize;
        
        String permutation = "";
        for(int i=0; i<usedSize; i++) {
            if(!used[i]) {
                if(groupIndex == 0) {
                    used[i] = true;
                    permutation += String.valueOf(i+1);
                    break;
                } else {
                    groupIndex--;
                }
            }
        }
        permutation += getPermutation(groupSize, permutationIndex % groupSize, length-1, used, usedSize);
        return permutation;
    }
    private int factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n-1);
    }
}