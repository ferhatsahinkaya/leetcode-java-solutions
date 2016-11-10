public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        if(k > n) return combinations;
        if(k == 0) {
            combinations.add(new ArrayList<>());
        } else {
            long subsetCount = 1 << n;
            for(long i=0; i<subsetCount; i++) {
                if(hasSetBits(i, k)) {
                    combinations.add(getCombination(i));
                }
            }
        }
        return combinations;
    }
    private List<Integer> getCombination(long n) {
        List<Integer> combination = new ArrayList<>();
        for(int i=0; i<64; i++) {
            if((1 & n) != 0) combination.add(i+1);
            n >>= 1;
        }
        return combination;
    }
    private boolean hasSetBits(long n, int k) {
        int count = 0;
        while(n != 0) {
            n = (n & (n-1));
            count++;
        }
        return (count == k);
    }
}