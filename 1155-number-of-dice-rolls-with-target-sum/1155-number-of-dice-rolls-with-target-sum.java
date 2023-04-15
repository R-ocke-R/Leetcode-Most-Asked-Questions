class Solution {
    private int mod = (int) Math.pow(10, 9) +7;
    public int recursive(int dice, int totalNumber, int k, int target){
        // if(dice > totalNumber) return 0;
        if(totalNumber==dice){
            if(target==0) return 1;
            else return 0;
        }
        
        // working
        int ans=0;
        for(int face = 1; face <= k; face++){
            if(face<=target) ans+=recursive(dice+1, totalNumber, k, target-face);
        }
        return ans;
    }
    
    public int memo(int dice, int totalNumber, int k, int target, int[][] dp){
        if(totalNumber==dice){
            if(target==0) return 1;
            return 0;
        }
        if(dp[dice][target]!=-1) return dp[dice][target];
        
        int ans=0;
        for(int face = 1; face <= k; face++){
            if(face<=target) ans = (ans + memo(dice+1, totalNumber, k, target-face, dp)%mod) % mod;
        }
        dp[dice][target]=ans;
        return dp[dice][target];
    }
    public int numRollsToTarget(int n, int k, int target) {
        // TLE
        // return recursive(0, n, k, target);
        
        // Memoization
        int[][] dp= new int [n][target+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return memo(0, n, k, target, dp);
        
    }
}