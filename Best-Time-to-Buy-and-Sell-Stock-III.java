class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] next = new int[3][2], curr = new int[3][2];

        for (int day = n - 1; day >= 0; day--) {
            for (int trans = 1; trans <= 2; trans++) {
                curr[trans][1] = Math.max(-prices[day] + next[trans][0], next[trans][1]);
                curr[trans][0] = Math.max(prices[day] + next[trans - 1][1], next[trans][0]);
            }
            next = curr.clone(); 
        }
        return next[2][1];
    }
}