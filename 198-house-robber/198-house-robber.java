class Solution {
    public int rob(int[] nums) {
        //introducing a new series of questions here, house robber type.
//         can this be solved with binary Search?
        
        // one approach is to have two for loops with +2 increment, 
        // one starting from 0 other from 1 index.
        
        //first code its recursive approach, now go through and code dp explained by sir.
        //dp space and time is order of n
        int n=nums.length;
        if(n==1){return nums[0];}
        if(n==2){return Math.max(nums[0], nums[1]);}
        int[] dp= new int [n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        
        for(int i=2;i<n;i++){
            int steal=nums[i]+dp[i-2];
            int not=dp[i-1];
            dp[i]=Math.max(steal, not);
            
        }
        return dp[dp.length-1];
    }
}