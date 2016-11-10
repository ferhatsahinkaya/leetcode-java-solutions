public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int minIndex = 0;
        int maxProfit = 0;
        for(int i=1; i<length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - prices[minIndex]);
            minIndex = (prices[minIndex] > prices[i]) ? i : minIndex;
        }
        return maxProfit;
    }
}