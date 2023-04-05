class Solution {
    int maximum=0;

    public int recursive(char[][] matrix, int i, int j, int n, int m){
        if(i>=n || j>=m) return 0;
        
        int right = recursive(matrix, i, j+1, n, m);
        int down = recursive(matrix, i+1, j, n, m);
        int diagnol= recursive(matrix, i+1, j+1, n, m);
        
        if(matrix[i][j]=='1'){
                       
            int ans=1+Math.min(right, Math.min(down, diagnol));
            // System.out.println(ans);
            maximum= Math.max(maximum, ans);
            return ans;
        }
        else return 0;
        
    }
    public void tabulation(char[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=n-1;i>=0; i--){
            for(int j=m-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    int right = dp[i][j+1];
                    int down = dp[i+1][j];
                    int diagnol= dp[i+1][j+1];
                    dp[i][j]=1+Math.min(right, Math.min(down, diagnol));
                    maximum = Math.max(maximum, dp[i][j]);
                }
                else {
                    dp[i][j]=0;
                }
            }
        }
    }
    public int maximalSquare(char[][] matrix) {
//         int n= matrix.length;
//         int m= matrix[0].length;
        
//         // maximum=0;
//         recursive(matrix, 0, 0, n, m);
        
        // tabulation call
        tabulation(matrix);
        
        return maximum*maximum;
    }
}