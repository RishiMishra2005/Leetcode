class Solution {
    
    public int findMaxFish(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxFish=0;       

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0) continue;    

                maxFish=Math.max(maxFish, dfs(grid, i, j, m, n));
            }
        }

        return maxFish;
    }

    int dfs(int[][] grid, int i, int j, int m, int n){        
        int fish=0;
        
        if( i<0 || i>=m || j<0 || j>=n || grid[i][j]==0) return fish;   
             
        fish+=grid[i][j];
        
        grid[i][j]=0; //Visited

                                           
        fish+=dfs(grid, i, j+1, m, n);
        fish+=dfs(grid, i, j-1, m, n);
        fish+=dfs(grid, i+1, j, m, n);
        fish+=dfs(grid, i-1, j, m, n);
        

        return fish;
    }

}