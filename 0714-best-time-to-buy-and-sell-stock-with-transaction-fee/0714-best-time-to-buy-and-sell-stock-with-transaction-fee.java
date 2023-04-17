class Solution {
    public int maxProfit(int[] prices, int fee) {
        return space(prices, fee);
    }
    public int space(int[] prices, int fee)
    {
        int n = prices.length;
        int curr0 = 0;
        int curr1 = 0;
        int next0 = 0;
        int next1 = 0;
        // base is 0 so its automatically filled.
        for(int index = n-1; index >= 0; index --){
            for(int buy = 0 ; buy <= 1; buy++){
                if (buy==1) {
                    // in buy itself there are two choices.memo
                    int bought = -(prices[index]+fee) + next0;
                    int skipB = 0 + next1;
                    curr1 = Math.max(bought, skipB);
                }
                else {
                    int sell = (prices[index] + next1);
                    int skipS = 0 + next0;
                    curr0 = Math.max(sell, skipS);
                } 
            }
            next0=curr0;
            next1=curr1;
        }
        return next1;
    }
}