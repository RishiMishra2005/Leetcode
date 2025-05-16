class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int cnt=0;
        int[] rowCnt=new int[m]; 
        int[] colCnt=new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){                   
                    rowCnt[i]++;
                    colCnt[j]++;                    
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){                   
                    if(rowCnt[i]>1 || colCnt[j]>1){
                        cnt++;
                    }                 
                }
            }
        }

        return cnt;
    }
}