class Solution {
    public void setZeroesBrute(int[][] matrix) {
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
    the above code does it, but fails on the test case which has -1 in the input array itself. in this case we could've 
    looked at the constraints first then went ahead to code the solution (in this case we won't code because the 
    constraints would fail the solution)
    TC: O(n*m)*O(n+m) + O(n*m) 
    first*-1update + back to zero update

    Better Approach: Use single dimension array of row and col which will tell us which rows need to be marked zero
    */
    public void setZeroesOP(int[][] matrix){
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
    /* Time Complexity O(n*m) 
    Space complexity O(n+M)
    Now can we furthur optimize the solution.
    we can't optimise the time as its the time required to traverse the 2D array.
    but let's have an attempt at the space complexity.
    */
    public void setZeroesFinal(int[][]matrix){
        /** Now we furthur optimise the space, and move from O(m+n) to o(1) space.
        its very implicit to think that the only way not to use extra space, is 
        to use the space provided/occupied by the matrix itself, so we use the 
        matrix[0] row and column as flag holders.*/


        /**Steps
        1. using row1:matrix[0] and column2:matrix[i][0] as place holders.
        2. we also take col0 variable for flag of col0.
        3. updating the flags
        4. updating the complete matrix using flags
        5. updating row0
        6. updating col0
         */

        int n = matrix.length; // number of rows
        int m = matrix[0].length; // number of columns
        int col0=1;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    // set row
                    matrix[i][0]=0;
                    
                    // set col
                    if(j!=0) matrix[0][j]=0;
                    else col0=0;
                }                 
            }
        }
        // step 4
        // updating to zero but only to elements whose row or col is not zero so we iterate from 1
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
            }
        }
        // step 5
        // first work for row 0((0, 0), (0, 1), (0, 2),...)
        // it depends on [0][0] 
        if(matrix[0][0]==0) {
            for(int j=1;j<m;j++){
                matrix[0][j]=0;
            }
        }
        //step 6
        // now work for col0 ((0,0),(1,0),(2,0))
        if(col0==0){
        for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
        
    }

    public void setZeroes(int[][]matrix){
        /** 
        Using this function as a caller function for the 3 approaches
        1. brute -> setZeroesBrute(matrix)
        2. optimized -> setZeroesOP(matrix)
        3. Optimal ->setZeroesFinal(matrix) 
        */
        setZeroesFinal(matrix);
    }
    
}