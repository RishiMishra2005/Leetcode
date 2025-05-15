class Solution {
    public int snakesAndLadders(int[][] board) {
        int rows = board.length, cols = board[0].length, target = rows * cols, r, c, p;
        boolean[] visited = new boolean[rows * cols + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] {0, 1});
        visited[1] = true;

        while (!q.isEmpty()) 
        {
            int[] step_pos = q.poll();
            int s = step_pos[0] / 1000 + 1;
            for (int i = 1; i <= 6; i++) 
            {
                p = step_pos[1] + i;
                if (visited[p]) continue;
                visited[p] = true;

                r = rows - (p - 1) / cols - 1;
                c = (p - 1) % cols;
                if ((rows - r - 1) % 2 == 1) 
                    c = cols - c - 1; 
                int ladder = board[r][c];
                
                if (ladder > 0 && ladder <= target)
                    p = ladder;
                if (p == target) 
                    return s;
                q.offer(new int[] {s * 1000 + 500 - p, p});
            }
        }
        return -1;
    }
}