public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length <= 1) return 0;
        
        int[] profits = new int[length];
        profits[0] = 0;
        
        for(int i=1; i<length; i++) {
            int profit = profits[i-1];
            for(int j=i-1; j>=0; j--) {
                profit = Math.max(profit, (prices[i] - prices[j]) + ((j >= 2) ? profits[j-2] : 0));
            }
            profits[i] = profit;
        }
        return profits[length-1];
    }
}