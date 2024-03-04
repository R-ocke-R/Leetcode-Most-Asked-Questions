class Solution {
    public void setZeroesA1(int[][] matrix) {
        int count = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] zero = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(matrix[i][j]==0){
                    int row = i;
                    int col = j;
                    for(int x = 0; x<m;x++){
                        if(matrix[row][x]!=0){matrix[row][x]=-1;}
                    }
                    for(int y=0;y<n;y++){
                        if (matrix[y][col]!=0) {matrix[y][col]=-1;}
                    }   
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(matrix[i][j]==-1) matrix[i][j]=0;
            }
        }
    }
    /* Appraoch 1 was brute, since we can't update the zeros' in-place as soon as we find them, the better option was to 
    update with -1 as a flag then traverse once again to turn the -1 back to 0.
    the above code does it, but fails on the test case which has -1 in the input array itself. 
    TC: O(n*m)*O(n+m) + O(n*m) 
    first*-1update + back to zero update

    Better Approach: Use single dimension array of row and col which will tell us which rows need to be marked zero
    */
    public void setZeroes(int[][] matrix){
        int n= matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(matrix[i][j]==0){
                    col[j] = true;
                    row[i]= true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(row[i] || col[j] ) matrix[i][j]=0;
            }
        }
    }
}