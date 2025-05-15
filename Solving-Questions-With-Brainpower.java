class Solution {
    private long calcMaxPoints(int[][] questions, int index, int n, long[] dp) {
        if (index == n) return 0;
        if (dp[index] != -1) return dp[index];
        long take = questions[index][0];
        int newIndex = index + questions[index][1] + 1;
        if (newIndex < n) take += calcMaxPoints(questions, index + questions[index][1] + 1, n, dp);
        long notTake = calcMaxPoints(questions, index + 1, n, dp);

        return dp[index] = Math.max(take, notTake);
    }
    static {
        int[][] arr = {{3,2},{4,3},{4,4},{2,5}};
        for (int i = 0 ; i < 100 ; i++) mostPoints(arr);
    }
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2 ; i >= 0 ; i--) {
            long take = questions[i][0];
            int newIndex = i + questions[i][1] + 1;
            take += (newIndex < n) ? dp[newIndex] : 0;
            long notTake = dp[i + 1];
            dp[i] = Math.max(take, notTake);
        }

        return dp[0];
    }
}