class Solution {
    
    List<List<String>> ans=new ArrayList<>();
    
    
    
    public void saveBoard(int[][] path, int n){
        // System.out.println("Called");
        List<String> nAns=new ArrayList<>();
        for(int i=0;i<n;i++){
            String little = new String();
            for(int j=0;j<n;j++){
                if(path[i][j]==0) little+=".";
                else little+="Q";
            }
            nAns.add(little);
        }
        ans.add(nAns);
        return;
    }
    
    public boolean placePossible(int[][] path, int col, int n, int i){
        int x=i;
        int y=col;
        // check for row
        while(y>=0){
            if(path[x][y]==1) return false;
            y--;
        }
        // check for upper diagnol
        x=i;
        y=col;
        while(x>=0 && y>=0){
            if(path[x][y]==1) return false;
            x--;
            y--;
        }
        x=i;
        y=col;
        while(x<n && y>=0) {
            if(path[x][y]==1) return false;
            x++;
            y--;
        }
        return true;
    }
    
    
    public void queenPlacer(int[][] path, int col, int n){
        
        if(col==n) {
            saveBoard(path, n);
            return ;
        }
        
        // else we have to place a queen in this col
        for(int i=0;i<n;i++){
            if(placePossible(path, col, n, i)){
                // if queen can be placed at [i][col].
                path[i][col]=1;
                
                queenPlacer(path, col+1, n);
                
                path[i][col]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        int[][] path=new int[n][n];
        queenPlacer(path, 0, n);
        return ans;
    }
}