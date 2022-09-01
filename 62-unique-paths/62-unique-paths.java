class Solution {
    public int uniquePaths(int m, int n) {
        // solving this with backtracking with m and n going to 2^m^n 
        // which is 2^(100^100), very sure of an TLE.
        
        //since we are the all the unique ways we need to optimise the algorithsm
        // for the same we will use DP
        // System.out.println(m+""+n);
        int[][] arr= new int[m][n];
        for(int i=0;i<n;i++){
            arr[0][i]=1;
        }
        for(int i=0;i<m;i++){
            arr[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j]=arr[i][j-1]+arr[i-1][j];
            }
        }
        return arr[m-1][n-1];
    }
}