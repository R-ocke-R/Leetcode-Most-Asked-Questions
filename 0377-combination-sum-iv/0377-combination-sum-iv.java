class Solution {
    public int combinationSum4(int[] nums, int target) {
        return dp(nums, target, nums.length);
    }
    public int function(int[] candidates, int target, int n, int[] memo){
        // base case.
        if(target<0) return 0;
        if(target==0) return 1;
        if(memo[target]!=0) return memo[target];
        // function calling
        int ans=0;
        for(int index = 0; index < n; index ++){
            ans+=function(candidates, target-candidates[index], n, memo);            
        }
        memo[target]=ans;
        return ans;
    }
    public int dp(int[] candidates, int target, int n){
        // base case.
        int[] dp = new int[target+1];
        dp[0]=1;
        
        
        for(int index = 1; index <= target; index ++){
            for(int nums=0; nums < n; nums++ ){
                if(index-candidates[nums]>=0) dp[index]+=dp[index-candidates[nums]];
            }
        }
        return dp[target];
    }
}