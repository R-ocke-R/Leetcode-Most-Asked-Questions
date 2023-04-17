class Solution {
    public int maxProfit(int k, int[] prices) {
        int limit = k;
        return space(prices, limit);
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