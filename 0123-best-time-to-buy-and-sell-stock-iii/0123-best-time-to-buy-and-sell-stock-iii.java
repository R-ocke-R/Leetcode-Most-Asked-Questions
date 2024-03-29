class Solution {
    public int maxProfit(int[] prices) {
        // return recursive(prices, 0, true, 2);
        // Recursive TLE solution
        
        // moving on to memoisation
        // [ index][buy][limit];
        // int n = prices.length;
        // int limit = 2;
        // int[][][] dp = new int [n][2][limit+1];
        // for(int a = 0; a < dp.length; a++ ){
        //     for(int b = 0; b<dp[0].length; b++){
        //         Arrays.fill(dp[a][b], -1);
        //     }
        // }
        // return memo(prices, 0, 1, limit, dp);
        
        // moving on to tabulation
        // int limit=2;
        // return tabulation(prices, limit);
        
        // now to space optimisation
        int limit = 2;
        return space(prices, limit);

    }
    public int recursive(int[] prices, int index, boolean buy, int limit)
    {
        
        // base
        if(index==prices.length || limit == 0) return 0;        
        
        int value = 0;
        if (buy) {
            // in buy itself there are two choices.
            int bought = -(prices[index]) + recursive(prices, index+1, false, limit);
            int skipB = 0 + recursive(prices, index+1, true, limit);
            value = Math.max(bought, skipB);
        }
        else {
            int sell = (prices[index] + recursive(prices, index+1, true, limit-1));
            int skipS = 0 + recursive(prices, index+1, false, limit);
            value = Math.max(sell, skipS);
        }
        return value;
    }
    public int memo(int[] prices, int index, int buy, int limit, int[][][] dp)
    {
        
        // base
        if(index==prices.length || limit == 0) return 0;     
        if(dp[index][buy][limit]!=-1) return dp[index][buy][limit];
        
        int value = 0;
        if (buy==1) {
            // in buy itself there are two choices.
            int bought = -(prices[index]) + memo(prices, index+1, 0, limit, dp);
            int skipB = 0 + memo(prices, index+1, 1, limit, dp);
            value = Math.max(bought, skipB);
        }
        else {
            int sell = (prices[index] + memo(prices, index+1, 1, limit-1, dp));
            int skipS = 0 + memo(prices, index+1, 0, limit, dp);
            value = Math.max(sell, skipS);
        }
        dp[index][buy][limit] = value;
        return dp[index][buy][limit];
    }
    public int tabulation(int[] prices, int lnt)
    {
        // dp creaion and filling of base cases
        int n=prices.length;
        int[][][] dp= new int [n+1][2][lnt+1];
        // order [index][buy][limit]
        // base cases values are already 0 so no shit there
        
        for(int index=n-1; index >= 0; index--){
            for(int buy =0; buy <=1; buy++){
                for(int limit = 1; limit <= lnt; limit++){
                    int value = 0;
                    if (buy==1) {
                        // in buy itself there are two choices.
                        int bought = -(prices[index]) + dp[index+1][0][limit];
                        int skipB = 0 + dp[index+1][1][limit];
                        value = Math.max(bought, skipB);
                    }
                    else {
                        int sell = (prices[index] + dp[index+1][1][limit-1]);
                        int skipS = 0 + dp[index+1][0][limit];
                        value = Math.max(sell, skipS);
                    }
                    dp[index][buy][limit] = value;
                }
            }
        }
        return dp[0][1][lnt];
    }
    public int space(int[] prices, int lnt){
        int n=prices.length;
        int[][][] dp= new int [n+1][2][lnt+1];
        int[][] next = new int[2][lnt+1];
        int[][] curr = new int[2][lnt+1];
        // order [index][buy][limit]
        // base cases values are already 0 so no shit there
        
        for(int index=n-1; index >= 0; index--){
            for(int buy =0; buy <=1; buy++){
                for(int limit = 1; limit <= lnt; limit++){
                    int value = 0;
                    if (buy==1) {
                        // in buy itself there are two choices.
                        int bought = -(prices[index]) + next[0][limit];
                        int skipB = 0 + next[1][limit];
                        value = Math.max(bought, skipB);
                    }
                    else {
                        int sell = (prices[index] + next[1][limit-1]);
                        int skipS = 0 + next[0][limit];
                        value = Math.max(sell, skipS);
                    }
                    curr[buy][limit] = value;
                }
            }
            next = curr;
        }
        return curr[1][lnt];

    }
}