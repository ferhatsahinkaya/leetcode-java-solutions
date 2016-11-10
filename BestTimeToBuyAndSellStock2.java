public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int minIndex = 0;
        int profit = 0;
        for(int i=1; i<length; i++) {
            if((i+1 < length) && (prices[i+1] > prices[i])) {
                minIndex = (prices[i] < prices[minIndex]) ? i : minIndex;
                continue;
            }
            if(prices[i] > prices[minIndex]) {
                profit += (prices[i] - prices[minIndex]);
                minIndex = i+1;
            } else {
                minIndex = i;
            }
        }
        return profit;
    }
}