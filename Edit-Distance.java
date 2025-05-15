class Solution {
    private int solve(int i, int j, String s1, String s2, int dp[][]) {
        if (i == 0 && j == 0) {
            if (s1.charAt(i) == s2.charAt(j))
                return 0;
            else
                return 1;
        }
        if (j == -1)
            return i + 1;
        if (i == -1)
            return j + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int insert = 300000000;
        int replace = 30000000;
        int delete = 30000000;

        if (s1.charAt(i) == s2.charAt(j)) 
            return dp[i][j] = solve(i - 1, j - 1, s1, s2, dp);
        else {
            insert = 1 + solve(i, j - 1, s1, s2, dp);
            replace = 1 + solve(i - 1, j - 1, s1, s2, dp);
            delete = 1 + solve(i - 1, j, s1, s2, dp);
        }

        return dp[i][j] = Math.min(insert, Math.min(replace, delete));
    }

    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];

        for (int[] I : dp)
            Arrays.fill(I, -1);

        return solve(word1.length() - 1, word2.length() - 1, word1, word2, dp);
    }
}