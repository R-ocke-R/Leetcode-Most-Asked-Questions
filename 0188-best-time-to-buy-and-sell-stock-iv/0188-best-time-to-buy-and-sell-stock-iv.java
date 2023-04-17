class Solution {
    public int maxProfit(int k, int[] prices)
    {
        // int limit = k;
        // return space(prices, limit);
        // changing the limit from last question to this. and reusing the previous-best code. 
        
        // in the last question we used 3d DP, and even in space function the space is still not O(1) is O(2k) where k is limit
        // so we optimise it by merging the parameters.
        // return newRecursive(prices, 0, 0, k);
        // working function but slow -> TLE
        
        // Memo
        // int n= prices.length;
        // int[][] dp = new int[n][k*2];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return newMemo(prices, 0, 0, k, dp);
        
        // tabulation
        // return tabulation(prices, k);
        
        
        //final new space optimised solution O(1);
        return newSpace(prices, k);
    }
    public int space(int[] prices, int lnt)
    {
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
    public int newRecursive(int[] prices, int index, int operations, int k)
    {
        // this function is an attempt to reduce the paramaters, so that while optimising to dp solution we can 
        // move from 3d to 2d.
        
        // base
        if(index==prices.length) return 0;
        if(operations==2*k) return 0;
        int value=0;
        if(operations%2==0){
            int bought = -(prices[index]) + newRecursive(prices, index+1, operations+1, k);
            int skipB = 0 + newRecursive(prices, index+1, operations, k);
            value = Math.max(bought, skipB);
        }
        else {
            int sell = (prices[index] + newRecursive(prices, index+1, operations+1, k));
            int skipS = 0 + newRecursive(prices, index+1, operations, k);
            value = Math.max(sell, skipS);
        }
        return value;
    }
    public int newMemo(int[] prices, int index, int operations, int k, int[][]dp)
    {
        if(index==prices.length || operations==2*k) return 0;
        if(dp[index][operations]!=-1) return dp[index][operations];
        int value=0;
        if(operations%2==0){
            int bought = -(prices[index]) + newMemo(prices, index+1, operations+1, k, dp);
            int skipB = 0 + newMemo(prices, index+1, operations, k, dp);
            value = Math.max(bought, skipB);
        }
        else {
            int sell = (prices[index] + newMemo(prices, index+1, operations+1, k, dp));
            int skipS = 0 + newMemo(prices, index+1, operations, k, dp);
            value = Math.max(sell, skipS);
        }
        dp[index][operations] = value;
        return dp[index][operations];
    }
    public int tabulation(int[] prices, int k)
    {
        int total = 2*k;
        int n= prices.length;
        int[][] dp= new int[n+1][total+1];
        
        for(int index = n-1 ; index >= 0; index--){
            for(int operations = total-1 ; operations >= 0;  operations --) {
                int value=0;
                if(operations%2==0){
                    int bought = -(prices[index]) + dp[index+1][operations+1];
                    int skipB = 0 + dp[index+1][operations];
                    value = Math.max(bought, skipB);
                }
                else {
                    int sell = (prices[index] + dp[index+1][operations+1]);
                    int skipS = 0 + dp[index+1][operations];
                    value = Math.max(sell, skipS);
                }
                dp[index][operations]=value;
            }
        }
        return dp[0][0];
    }
    public int newSpace(int[] prices, int k){
        int total = 2*k;
        int n= prices.length;
        // int[][] dp= new int[n+1][total+1];
        int[] next = new int[total+1];
        int[] curr = new int[total+1];
        
        for(int index = n-1 ; index >= 0; index--){
            for(int operations = total-1 ; operations >= 0;  operations --) {
                int value=0;
                if(operations%2==0){
                    int bought = -(prices[index]) + next[operations+1];
                    int skipB = 0 + next[operations];
                    value = Math.max(bought, skipB);
                }
                else {
                    int sell = (prices[index] + next[operations+1]);
                    int skipS = 0 + next[operations];
                    value = Math.max(sell, skipS);
                }
                curr[operations]=value;
            }
            next=curr;
        }
        return next[0];
    }
}