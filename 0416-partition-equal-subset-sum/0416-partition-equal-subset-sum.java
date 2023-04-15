class Solution {
        
    public boolean caller(int[] nums, int n, int index, int target){
        
        // base
        if(target==0) return true;
        if(target < 0 || index==n) return false;
        
        // function working
        boolean addCall = caller(nums, n, index+1, target-nums[index]);
        boolean Call = caller(nums, n, index+1, target);
        
        return (Call || addCall);
    }
    public boolean memo(int[] nums, int index, int target, int[][] dp){
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
        return memo(nums, 0, sum/2, dp);
    }
}