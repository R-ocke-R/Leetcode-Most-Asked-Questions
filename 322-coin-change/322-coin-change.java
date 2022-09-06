class Solution {
    
    public int recursion(int[] coins, int amt){
        if (amt<0) return Integer.MAX_VALUE;
        if (amt==0) return 0;
        
        int m=Integer.MAX_VALUE;
        
        for(int i=0;i<coins.length;i++){
            if(amt>=coins[i]) m=Math.min(m, recursion(coins, amt-coins[i]));
        }
        
        if(m!=Integer.MAX_VALUE) return m+1;
        return m;
    }// this can can be made clearner.
    
    public int topdown(int[] coins, int amt, int[] dp){
        if(amt<0) return Integer.MAX_VALUE;
        if(amt==0) return dp[amt];
        
        if(dp[amt]!=0) return dp[amt];
        // System.out.println("call for "+ amt);
        int mini=Integer.MAX_VALUE;
        
        for(int i=0;i<coins.length;i++)
        {
            int dum=topdown(coins, amt-coins[i],dp);
            if(dum!=Integer.MAX_VALUE){
                mini=Math.min(mini, dum+1);
            }
        }
        dp[amt]=mini;
        return mini;
    }
    public int coinChange(int[] coins, int amt) {
        //above was approach 1-> Real Life described in copy
        // Arrays.sort(coins);
        // Arrays.sort(coins, Collections.reverseOrder());
        // int count=0;
        // for(int i=coins.length-1;i>=0;i--){
        //     // while(amt>=coins[i]){
        //     //     amt-=coins[i];
        //     //     count++;
        //     // }
        //     if(amt>=coins[i]) {
        //         count+=amt/coins[i];
        //         amt=amt%coins[i];
        //         System.out.println(amt);
        //     }
        // }
        // if(amt==0) return count;
        
        //recursion
        
        // int ans=recursion(coins, amt);
        // if(ans==Integer.MAX_VALUE) return -1;
        // return ans;


        //Top down R + M
        int [] dp=new int[amt+1];
        //step 2 fill dp with base cases.
        dp[0]=0;
        int ans= topdown(coins, amt, dp);
        // System.out.println(Arrays.toString(dp));
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}