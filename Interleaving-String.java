class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];

        return backtrack(s1, s2, s3, 0, 0, dp);
    }

    private boolean backtrack(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
        if (i + j == s3.length()) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int k = i + j;
        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = backtrack(s1, s2, s3, i + 1, j, dp);
        }
        if (!result && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = backtrack(s1, s2, s3, i, j + 1, dp);
        }
        dp[i][j] = result;
        return result;
    }
}