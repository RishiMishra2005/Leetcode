public class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int n=tri.size();
        int dp[][]=new int[n][n];
        List<Integer> nrow=tri.get(n-1);
        for(int i=0;i<n;i++){
            dp[n-1][i]=nrow.get(i);
        }  
        solve(n-2,tri,dp);
        return dp[0][0];
    }
    public void solve(int i,List<List<Integer>> tri,int dp[][]){
        if(i<0)  return;
        List<Integer> row=tri.get(i);
        for(int j=0;j<=i;j++){
            dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+row.get(j);
        }
        solve(i-1,tri,dp);
    }
}