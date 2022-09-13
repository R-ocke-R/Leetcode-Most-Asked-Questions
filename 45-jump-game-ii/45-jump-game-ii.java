class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //base 
        dp[n-1]=0;
        for(int i=n-2; i>=0;i--){
            
            int val=nums[i];
            int minval=Integer.MAX_VALUE;
            for(int j=i+1;j<=i+val;j++){
                // System.out.println("for index "+ i+" max check indexes are "+ j );
                if(j<=n-1){
                    minval=Math.min(minval, dp[j]);
                }
                
            }
            // System.out.println("minimum for the index"+i+"is"+minval);
            if(minval!=Integer.MAX_VALUE)
            dp[i]=1+minval;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}

// this is order of n^2 solution, do try order of n yourself.