class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 1 || board[0].length == 1){
            return;
        }

        int m = board.length;
        int n = board[0].length;

        char[][] out = new char[m][n];
        for(char[] row : out){
            Arrays.fill(row, 'X');
        }

        for(int j = 0; j < board[0].length; j++){
            if(board[0][j] == 'O'){
                dfs(board, 0, j, out);
            }
        }

        for(int j = 0; j < board[0].length; j++){
            if(board[m - 1][j] == 'O'){
                dfs(board, m - 1, j, out);
            }
        }
        
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0, out);
            }
        }

        for(int i = 0; i < board.length; i++){
            if(board[i][n - 1] == 'O'){
                dfs(board, i, n - 1, out);
            }
        }

        for(int i = 0; i < board.length; i++){
            board[i] = out[i];
        }
    }

    public void dfs(char[][] board, int i, int j, char[][] out){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }

        out[i][j] = 'O';
        board[i][j] = '1';
        dfs(board, i + 1, j, out);
        dfs(board, i - 1, j, out);
        dfs(board, i, j + 1, out);
        dfs(board, i, j - 1, out);
    }
}
