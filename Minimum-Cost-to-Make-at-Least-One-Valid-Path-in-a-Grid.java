class Solution {
    public int minCost(int[][] grid) {
       rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        
        int cost = 0;
        runAll(grid, 0,0);
        while(!dq.isEmpty()) {
            for(int round = dq.size(); round>0; round--) {
                int[] cur= dq.pollFirst();
                int r=cur[0], c=cur[1];
                if(r==rows-1 && c==cols-1) return cost;
                runAll(grid, r, c);
                for(int k=0; k<4; k++) {
                    runAll(grid, r+dr[k], c+dc[k]);
                }
            }
            cost++;
        }
        return -1;
    }
    Deque<int[]> dq = new LinkedList();
    int[] dr = new int[]{0,0,1,-1}, dc = new int[]{1,-1,0,0};
    boolean[][] visited;
    int rows, cols;
    
    private void runAll(int[][] grid, int r, int c) {
        while(r>=0 && r<rows && c >= 0 && c<cols && !visited[r][c]) {
            visited[r][c] = true;
            int dir = grid[r][c]-1;
            dq.addLast(new int[]{r,c});
            r += dr[dir];
            c += dc[dir];
        }
    }
}