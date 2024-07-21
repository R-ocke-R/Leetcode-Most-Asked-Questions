class Solution {
    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        board[i][j] = 'Y';
        for (int[] d : dir) {
            int ix = i + d[0];
            int jy = j + d[1];
            if (ix > 0 && ix < m - 1 && jy > 0 && jy < n - 1 && board[ix][jy] == 'O') {
                dfs(board, ix, jy);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        // Traverse borders to find 'O's
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') dfs(board, i, j);
                }
            }
        }
        // Replace all 'O's with 'X's
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        // Replace all 'Y's back to 'O's
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
}