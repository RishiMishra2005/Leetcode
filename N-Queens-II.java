class Solution {
    public int totalNQueens(int n) {
        return solve(0, 0, 0, 0, n);
    }
    
    private int solve(int row, int cols, int diags, int antiDiags, int n) {
        if (row == n)
            return 1;

        int availablePositions = ((1 << n) - 1) & ~(cols | diags | antiDiags);

        int solutions = 0;
        while (availablePositions != 0) {
            int pos = availablePositions & -availablePositions;
            availablePositions &= availablePositions - 1;
            solutions += solve(row + 1, cols | pos, (diags | pos) << 1, (antiDiags | pos) >> 1, n);
        }

        return solutions;
    }
}