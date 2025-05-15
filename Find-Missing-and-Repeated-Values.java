class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int a=0, b=0;
        int[] arr=new int[n*n+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[grid[i][j]]++;
            }
        }
        for(int i=1; i<=n*n; i++){
            if(arr[i]>1){
                a=i;
            }

            if(arr[i]==0){
                b=i;
            }
        }

        return new int[]{a,b};
    }
}