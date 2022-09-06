class Solution {
    
//     public int recursive(int[] cost, int n, int[] dp){
        
//         if(n<0) return 0;
//         if(n==0) return cost[0];
        
//         if(dp[n]!=0) return dp[n];
        
//         int low=recursive(cost, n-1, dp);
//         int high=recursive(cost, n-2, dp);
        
//         if(n==cost.length) return Math.min(low, high);
        
//         dp[n]=cost[n]+Math.min(low, high);
        
//         return dp[n];
        
//     }
    
    public int minCostClimbingStairs(int[] cost) {

        int n=cost.length;
        // int[] dp= new int[n+1];        
        // return recursive(cost, n, dp);
        int[] dp=new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            // System.out.println(cost[i]+(Math.min(dp[i-1], dp[i-2])));
            dp[i]=cost[i]+(Math.min(dp[i-1], dp[i-2]));
        }
        return Math.min(dp[n-1], dp[n-2]);
        
        
    }
    

}