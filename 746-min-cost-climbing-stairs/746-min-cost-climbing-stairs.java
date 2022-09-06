class Solution {
    
    public int recursive(int[] cost, int n, int[] dp){
        
        if(n<0) return 0;
        if(n==0) return cost[0];
        
        if(dp[n]!=0) return dp[n];
        
        int low=recursive(cost, n-1, dp);
        int high=recursive(cost, n-2, dp);
        
        if(n==cost.length) return Math.min(low, high);
        
        dp[n]=cost[n]+Math.min(low, high);
        
        return dp[n];
        
    }
    
    public int minCostClimbingStairs(int[] cost) {

        int n=cost.length;
        int[] dp= new int[n+1];        
        return recursive(cost, n, dp);
        
    }
}