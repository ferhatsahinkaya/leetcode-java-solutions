public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] counts = new int[amount+1];
        Arrays.fill(counts, Integer.MAX_VALUE);
        counts[0] = 0;
        
        for(int i=1; i<=amount; i++) {
            int minValue = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(isValid(counts, i-coin)) {
                    minValue = Math.min(counts[i-coin]+1, minValue);
                }
            }
            counts[i] = minValue;
        }
        return (counts[amount] == Integer.MAX_VALUE) ? -1 : counts[amount];
    }
    private boolean isValid(int[] counts, int i) {
        if(i < 0) return false;
        return (counts[i] != Integer.MAX_VALUE);
    }
}