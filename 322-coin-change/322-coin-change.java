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
    
    public int bottomUp(int[] coins, int amt){
        
        //step 1
        int[] dp= new int[amt+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        //step 2
        dp[0]=0;

        // dp[i] contains the minimum number of coins, required to make the amount=i;
        // so to make dp[amt] there will be coins.length dependencies to dp[amt-coin_j] where coin_j is the value of coins[j] 
        for(int i=1;i<=amt;i++){
            for(int j=0;j<coins.length;j++){
                int coin_j=coins[j];
                if((i-coin_j)>=0 && dp[i-coin_j]!=Integer.MAX_VALUE)
                dp[i]=Math.min(dp[i], dp[i-coin_j]+1);
            }

            
        }
        // System.out.println(Arrays.toString(dp));
        if(dp[amt]==Integer.MAX_VALUE) return -1;
        return dp[amt];
    }
    
    
    
    // cleaner recursive code
    public int recurtry(int[] coins, int amt) {
        
        if(amt<0) return Integer.MAX_VALUE;
        if(amt==0) return 0;
        
        int mini=Integer.MAX_VALUE;
        
        for(int i=0;i<coins.length;i++){
            int call=recurtry(coins, amt-coins[i]);
            if(call !=Integer.MAX_VALUE) mini=Math.min(mini, call+1);
        }
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
        // int [] dp=new int[amt+1];
        // //step 2 fill dp with base cases.
        // dp[0]=0;
        // int ans= topdown(coins, amt, dp);
        // // System.out.println(Arrays.toString(dp));
        // if(ans==Integer.MAX_VALUE) return -1;
        // return ans;
        
        
        return bottomUp(coins, amt);
        
        //trying recursion again
        // int ans=recurtry(coins, amt);
        // if(ans==Integer.MAX_VALUE) return -1;
        // return ans;
        
    }
}