class Solution {
    // char[][] ans;
    
    public boolean isSafe(char[][] board, int i , int j, int x){
        // checks if x can be placed at location i, j while satisfying the 3 soduko rules
        char val=(char)(x+'0');
        for(int index=0;index<9;index++){
            if(board[index][j]==val) return false;
            if(board[i][index]==val) return false;
            if(board[3*(i/3)+index/3][3*(j/3)+index%3]==val) return false;
        }
        return true;
    }
    
    public boolean solverRecursive(char[][] board){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    // we found an empty cell
                    for(int x=1;x<=9;x++){
                        if(isSafe(board, i, j, x))
                        {
                            // System.out.println(x);
                            // (char)(a+'0'); 
                            board[i][j]=(char)(x+'0');
                            if(solverRecursive(board)){
                                // solution has been found using x
                                return true;
                            }
                            else{
                                //backtrack
                                board[i][j]='.';
                            }
                             
                        }
                    }
                    return false;
                }
            }
        }
        //we traversed all the indexes but all filled . found
        // addAns(board);
        return true;
    }
    
    
    public void solveSudoku(char[][] board) {
        //step 1:
        // make a recursive function which finds the next empty space and tries to fill it
        // please make a note that as per the question one solution always exist for the problem
        solverRecursive(board);      
    }
}