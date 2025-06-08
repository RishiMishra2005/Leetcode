class Solution {
    public int maxProfit(int k, int[] prices) {
       int n = prices.length;
        int[] profit = new int[n];
        for (int h = 1; h <= k; h++) {
            int top = prices[n-1];
            int best = 0;
            for (int i=n-1; i>= 0; i--) {
                top = Math.max(top, prices[i]+profit[i]);
                best = Math.max(best, top - prices[i]);
                profit[i] = best;
            }
        }
        return profit[0];
    }
}