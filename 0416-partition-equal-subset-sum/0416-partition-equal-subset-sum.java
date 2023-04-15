class Solution {
        
    public boolean caller(int[] nums, int n, int index, int target)
    {
        
        // base
        if(target==0) return true;
        if(target < 0 || index==n) return false;
        
        // function working
        boolean addCall = caller(nums, n, index+1, target-nums[index]);
        boolean Call = caller(nums, n, index+1, target);
        
        return (Call || addCall);
    }
    public boolean memo(int[] nums, int index, int target, int[][] dp)
    {
        if(target==0) return true;
        if(target < 0 || index==nums.length) return false;
        
        if(dp[index][target]!=0) {
            if(dp[index][target]==-1) return false;
            return true;
        }
        
        // function working
        boolean addCall = memo(nums, index+1, target-nums[index], dp);
        boolean Call = memo(nums, index+1, target, dp);
        
        boolean ans= (Call || addCall);
        if(!ans) dp[index][target]=-1;
        if(ans) dp[index][target]=1;
        
        return ans;
    }
    public boolean tabulation(int[] nums, int tSum)
    {
        // Stp 1: Creating DP and filling base case
        int n= nums.length;
        boolean [][] dp = new boolean[n+1][tSum+1];
        
        for(int index=0; index<=n; index++){
            dp[index][0]=true;
            // all target=0 are true;
        }
        for(int index = n-1 ; index >= 0; index--){
            for(int target = 0; target <= tSum; target ++){
                boolean addCall = false;
                if(target-nums[index]>=0) addCall = dp[index+1][target-nums[index]];
                boolean Call = dp[index+1][target];

                boolean ans= (Call || addCall);
                dp[index][target]=ans;
            }
        }
        return dp[0][tSum];
        
    }
    public boolean canPartition(int[] nums) {
        int n= nums.length;
        int sum=0;
        for(int i = 0 ; i < n; i++ ){
            sum+=nums[i];
        }
        
        int[][] dp = new int[n][(sum/2)+1];
        
        
        
        // if(sum%2!=0) return false;
        if ((sum & 1) == 1) return false;
        // return caller(nums, n, 0, sum/2);             Recursive call
        // return memo(nums, 0, sum/2, dp
        return tabulation(nums, sum/2);
    }
}