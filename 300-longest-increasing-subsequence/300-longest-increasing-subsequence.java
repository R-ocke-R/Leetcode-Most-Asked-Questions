class Solution {
    public int lengthOfLIS(int[] nums) {
        
        //implementing DP solution
        int n=nums.length;
        if(n==0) return 0;
        
        int[] dp= new int[n];
        dp[0]=1;
        int ans=1;
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=0;j<=i;j++){
                if(nums[i]>nums[j]) max=Math.max(max, dp[j]);
            }
            dp[i]=max+1;
            ans=Math.max(ans, dp[i]);
            
        }
        return ans;
        
    }
}

// 15-20 variation of this problem are available.
// LIS Problem

//longest
//increasing
//subsequence

/*

longest:-DP



*/