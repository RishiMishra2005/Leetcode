class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int[] dp = new int[n];
        int[] ind = new int[n];
        int res=0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int maxi=0;
            ind[i]=i;
            dp[i]=1;
            int limit = (arr[i] + 1) / 2;
            for(int j=0;j<i && arr[j]<=limit;j++){
                if(arr[i]%arr[j]==0 && dp[j]+1>dp[i])
                {
                    dp[i]=1+dp[j];
                    ind[i]=j;
                }
            }
            res=dp[i]>dp[res]?i:res;
        }
        while(res!=ind[res]){
            ans.add(arr[res]);
            res=ind[res];
        }
        ans.add(arr[res]);
        Collections.reverse(ans);
        return ans;
    }
}