class Solution {
    public int maximumWealth(int[][] accounts) {
        int n=accounts.length;
        int m=accounts[0].length;
        ArrayList<Integer> sum = new ArrayList<>();
        for(int i=0;i<n;i++){
            int s=0;
            for(int j=0;j<m;j++){
                s+=accounts[i][j];
            }
            sum.add(s);
        }
        Collections.sort(sum);
        return sum.get(n-1);
    }
}