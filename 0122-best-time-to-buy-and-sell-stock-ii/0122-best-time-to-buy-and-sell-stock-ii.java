class Solution {
    public int maxProfitGreedy(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length-1;i++){
            profit+=Math.max(0, prices[i+1]-prices[i]);
        }
        return profit;
    }
    
    public int maxProfit(int[] prices){
        // return recursive(prices, 0, true);
        // recursive solution ran but gave TLE
        
        int[][] dp = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        // Please note that boolean buy also need to behave as an integer for the array.
        // 0 is false and one is true.
        return memo(prices, 0, 1, dp);
    }
    public int recursive(int[] prices, int index, boolean buy )
    {
        
        // base
        if(index==prices.length) return 0;        
        
        int value = 0;
        if (buy) {
            // in buy itself there are two choices.
            int bought = -(prices[index]) + recursive(prices, index+1, false);
            int skipB = 0 + recursive(prices, index+1, true);
            value = Math.max(bought, skipB);
        }
        else {
            int sell = (prices[index] + recursive(prices, index+1, true));
            int skipS = 0 + recursive(prices, index+1, false);
            value = Math.max(sell, skipS);
        }
        return value;
    }
    public int memo(int[] prices, int index, int buy, int[][] dp)
    {
        if(index==prices.length) return 0;        
        if(dp[buy][index]!=-1) return dp[buy][index];
        
        int value = 0;
        if (buy==1) {
            // in buy itself there are two choices.memo
            int bought = -(prices[index]) + memo(prices, index+1, 0, dp);
            int skipB = 0 + memo(prices, index+1, 1, dp);
            value = Math.max(bought, skipB);
        }
        else {
            int sell = (prices[index] + memo(prices, index+1, 1, dp));
            int skipS = 0 + memo(prices, index+1, 0, dp);
            value = Math.max(sell, skipS);
        }
        dp[buy][index]=value;
        return dp[buy][index];
    }
    public int tabulation(int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[2][n];
        // base is 0 so its automatically filled.
        for(int index = n-1; index >= 0; index --){
            for(int buy = 0 ; buy <= 1; buy++){
                int value = 0;
                if (buy==1) {
                    // in buy itself there are two choices.memo
                    int bought = -(prices[index]) + dp[0][index+1];
                    int skipB = 0 + dp[1][index+1];
                    value = Math.max(bought, skipB);
                }
                else {
                    int sell = (prices[index] + dp[1][ index+1]);
                    int skipS = 0 + dp[0][index+1];
                    value = Math.max(sell, skipS);
                }
                dp[buy][index]=value;
            }
        }
        return dp[1][0];
    }
    
}