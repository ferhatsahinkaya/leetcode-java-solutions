public class Solution {
    public int getMoneyAmount(int n) {
        int[][] amounts = new int[n+1][n+1];
        for(int diff=2; diff <= n; diff++) {
            for(int left=1; left <= n - (diff-1); left++) {
                amounts[left][left + diff-1] = Integer.MAX_VALUE;
                for(int guess=left; guess <= left + diff - 1; guess++) {
                    int costForGuess = guess + ((guess == n) ? amounts[left][guess-1]
                                                             : Math.max(amounts[left][guess-1], amounts[guess+1][left+diff-1]));
                    amounts[left][left+diff-1] = Math.min(amounts[left][left+diff-1], costForGuess);
                }
            }
        }
        return amounts[1][n];
    }
}