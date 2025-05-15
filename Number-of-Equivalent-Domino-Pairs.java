class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] dp = new int[10][10];
        for(int[] domino : dominoes){
            dp[domino[0]][domino[1]]++;
        }
        int max = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = i; j < dp[i].length; j++){
                int count = dp[i][j];
                if(i != j){
                    count += dp[j][i];
                }
                max += count * (count - 1) / 2;
            }
        }
        return max;
    }
}
