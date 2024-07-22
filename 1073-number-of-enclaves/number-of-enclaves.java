class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 1st row ----
        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1){
                dfs(grid, 0, i);
            }
        }
        // 1st col |
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                dfs(grid, i, 0);
            }
        }
        // last col
        for(int i = 0; i < m; i++){
            if(grid[i][n-1] == 1){
                dfs(grid, i, n-1);
            }
        }
        // last row
        for(int i = 0; i < n; i++){
            if(grid[m-1][i] == 1){
                dfs(grid, m-1, i);
            }
        }
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) count ++;
            }
        }
        return count;

    }
    public void dfs(int[][] grid, int r, int c){
        grid[r][c] = 0;
        // traverse
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] d : dir) {
            int ix = r + d[0];
            int jy = c + d[1];
            if (ix > 0 && ix < m - 1 && jy > 0 && jy < n - 1 && grid[ix][jy] == 1) {
                dfs(grid, ix, jy);
            }
        }
    }
}


// boundry pe trasverse karo 
// call dfs for the nodes with 1 that are on the boundary and repalce all of those enclaves with 0
// traverse the whole matrix after this and count the number of 1's left
// return the count.