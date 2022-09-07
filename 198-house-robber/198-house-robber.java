class Solution {
    
    public int dpTNP(int[] nums){
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
    
    public int rob1Recursive(int[] nums, int i){
        
        //Recursion => Solve one case, rest recursion will handle
        
        //base
        if(i>=nums.length) return 0;
        
        //for each element I have two cases
        int take=nums[i]+rob1Recursive(nums, i+2);
        int move=rob1Recursive(nums, i+1);
         
        return Math.max(take, move);
    }
    
    public int rob2M(int[] nums, int i, int[] dp){
        if(i>=nums.length) return 0;
        
        if(dp[i]!=-1) return dp[i];
        
        int take=nums[i]+rob2M(nums, i+2, dp);
        int move=rob2M(nums, i+1, dp);
         
        dp[i]=Math.max(take, move);
        return dp[i];
        
    }
    public int rob(int[] nums) {
        //introducing a new series of questions here, house robber type.
//         can this be solved with binary Search? 
        //Let's see, BS is used to reduce the total range, we can do that here, 
        // but to select the subsequence for a given mid; would be still exponential 
        //as with for loops we aren't sure with how much gaps to take in subsquence.
        
        // another approach is to have two for loops with +2 increment, 
        // one starting from 0 other from 1 index.
        // which would definetely won't work as we may leave more adjacent elements 
        // (that leaving just one) inorder to increase the sum.\
        
        
        //first code its recursive approach, now go through and 
        // code dp explained by sir.
        //dp space and time is order of n
        
        //calling recursive
        // return rob1Recursive(nums, 0);
        
        // calling Memoization
        int[] dp=new int[nums.length];
        Arrays.fill(dp, -1);
        return rob2M(nums, 0, dp);
        
    }
}