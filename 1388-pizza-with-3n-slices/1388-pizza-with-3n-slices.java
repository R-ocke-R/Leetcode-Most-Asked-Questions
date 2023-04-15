class Solution {
    public int recursive(int[] slices, int index, int endIndex, int n)
    {
        // base case
        if(n==0 || index > endIndex) return 0;
        
        // consider
        int take = slices[index] + recursive(slices, index + 2, endIndex, n-1);
        
        int notTake = 0 + recursive(slices, index+1, endIndex, n);
        
        return Math.max(take, notTake);
    }
    public int memo(int[] slices, int index, int endIndex, int n, int[][] dp)
    {
        // base case
        if(n==0 || index > endIndex) return 0;
        if(dp[index][n]!=0) return dp[index][n];
        
        // consider
        int take = slices[index] + memo(slices, index + 2, endIndex, n-1, dp);
        
        int notTake = 0 + memo(slices, index+1, endIndex, n, dp);
        
        dp[index][n]=Math.max(take, notTake);
        return dp[index][n];
    }
    
    public int tabulation(int[] slices){
        // DP creation and base case conversion
        int n= slices.length;
        int[][] dp1 = new int[n+2][n];
        int[][] dp2 = new int[n+2][n];
        // base case returner is already 0 so we don't need to update the base cases in our DP array's
        
        for(int index = n-2; index >= 0; index --){
            for(int k = 1; k <= n/3; k++){
                int take = slices[index] + dp1[index + 2][k-1];

                int notTake = 0 + dp1[index+1][k];
                    
                dp1[index][k]=Math.max(take, notTake);
            }
        }
        int one = dp1[0][n/3];
        
        for(int index = n-1; index >= 1; index --){
            for(int k = 1; k <= n/3; k++){
                int take = slices[index] + dp2[index + 2][k-1];

                int notTake = 0 + dp2[index+1][k];
                    
                dp2[index][k]=Math.max(take, notTake);
            }
        }
        int two = dp2[1][n/3];
        
        return Math.max(one, two);
        
        
    }
    public int maxSizeSlices(int[] slices) {
        // recursive approach -> TLE
        // int n= slices.length;
        // int one = recursive(slices, 0, n-2, n/3);
        // int two = recursive(slices, 1, n-1, n/3);
        // return Math.max(one, two);
        
        
        
        // Memoization -> worked
//         int n= slices.length;
//         int[][] dp1 = new int[n][n];
//         int one = memo(slices, 0, n-2, n/3, dp1);
        
//         int[][] dp2 = new int[n][n];
//         int two = memo(slices, 1, n-1, n/3, dp2);
//         return Math.max(one, two);
        
        // Tabulation
        return tabulation(slices);
    }
}

/* 

as always understanding the problem is very crucial, and as we can understand 
intuitively, this is kind of like house robber question, KIND OF 

particularly HB2 where the houses were circular in arrangement. 


in addition to that specific condition, we also have an additional condition
alice and bob are also picking when you pick, and since we have 3n slices, 
in all we can only select n slices of pizza... **

*/