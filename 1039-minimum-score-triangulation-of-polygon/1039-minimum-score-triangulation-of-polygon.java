class Solution {
    
    public int recursive(int[] values, int i, int j){
        // base case
        if(i+1==j) return 0;
        
        // function working
        int ans=Integer.MAX_VALUE;
        for(int index = i+1; index < j; index++){
            ans = Math.min( ans , values[i]*values[index]*values[j] + recursive(values, i, index) + recursive(values, index, j));
        }
        
        return ans;
    }
    
    public int memo(int[] values, int i, int j, int[][] dp){
        // base
        if(i+1==j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int ans=Integer.MAX_VALUE;
        for(int index = i+1; index < j; index++){
            ans = Math.min( ans , values[i]*values[index]*values[j] + recursive(values, i, index) + recursive(values, index, j));
        }
        dp[i][j]=ans;
        return ans;
        
    }
    
    public int tabulation(int[] values){
        
        int n= values.length;
        int[][] dp = new int[n][n];
        
        for(int i=n-1; i>=0; i--){
            for(int j=i+2; j<n; j++){
                
                int ans=Integer.MAX_VALUE;
                for(int index = i+1; index < j; index++){
                    ans = Math.min( ans , values[i]*values[index]*values[j] + dp[i][index] + dp[index][j]);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][n-1];
        
    }
    public int minScoreTriangulation(int[] values) {
        // return recursive(values, 0, values.length-1);
        // recusive TLE solution
        
        // Memo
        // int n= values.length;
        // int[][] dp = new int[n+1][n+1];
        // for(int filler=0; filler<=n ; filler++) Arrays.fill(dp[filler], -1);
        // return memo(values, 0, n-1, dp);
        // also a TLE
        
        // Tabulation
        return tabulation(values);
    }
}