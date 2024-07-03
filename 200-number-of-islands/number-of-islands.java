class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public void traversal(char[][] grid, boolean[][] visited, int n, int m, int indexI, int indexJ){
        // for the given location we will be checking for land in all the f'ing directions.
        visited[indexI][indexJ] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(indexI, indexJ));

        int[] rows = new int[]{0, 0, 1, -1};
        int[] cols = new int[]{1, -1, 0, 0};
        while(!queue.isEmpty()){
            Pair top = queue.poll();
            
            for(int ind = 0; ind <= 3; ind ++){
                int nrow = rows[ind] + top.first;
                int ncol = cols[ind] + top.second;
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol<m && grid[nrow][ncol] == '1' && visited[nrow][ncol]==false){
                    queue.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                }
            }
        }
        return ;

    }
    public int numIslands(char[][] grid) {
        int count =0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count ++;
                    traversal(grid, visited, n, m, i, j);
                }
            }
        }
        return count;
    }
}