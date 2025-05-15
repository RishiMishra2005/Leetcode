class Solution {
    private int rows; 
    private int cols; 
    private int island = 0; 

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for(int r = 0; r < rows; r++) {
            search(grid, r); 
        }
        return island; 
    }

    public void search(char[][] grid, int r) {
        char[] fR = grid[r];

        for(int c = 0; c < cols; c++) {
            if(fR[c] == '1') { 
                mark(grid, r, c); 
                island++; 
            }
        }
    }

    public void mark(char[][] grid, int r, int c) {
        grid[r][c] = '*'; 

        if(r > 0 && grid[r - 1][c] == '1')
            mark(grid, r - 1, c);
        if(r + 1 < rows && grid[r + 1][c] == '1')
            mark(grid, r + 1, c);
        if(c > 0 && grid[r][c - 1] == '1')
            mark(grid, r, c - 1);
        if(c + 1 < cols && grid[r][c + 1] == '1')
            mark(grid, r, c + 1);
    }
}