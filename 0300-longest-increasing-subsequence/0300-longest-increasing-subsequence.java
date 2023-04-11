class Solution {
    
    public int recursive(int[] nums, int index, int prevIndex){
        // base
        if(index == nums.length){
            return 0;
        }
        // function working
        
        // exclude
        int val = recursive(nums, index+1, prevIndex);
        
        // include
        // condition
        if(prevIndex==-1 || nums[index]>nums[prevIndex]) val = Math.max(val, 1 + recursive(nums, index+1, index));
        
        return val;
    }
    public int memo(int[] nums, int index, int prevIndex, int[][] dp){
        // base
        if(index == nums.length){
            return 0;
        }
        if(dp[index][prevIndex+1]!=0) return dp[index][prevIndex+1];

        int val = memo(nums, index+1, prevIndex, dp);
        if(prevIndex==-1 || nums[index]>nums[prevIndex]) val = Math.max(val, 1 + memo(nums, index+1, index, dp));
        
        dp[index][prevIndex+1]=val;
        return val;
    }
    
    public int lengthOfLIS(int[] nums) {
        // recursive gives TLE
        // return recursive(nums, 0, -1);
        
       // moving to memo
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        return memo(nums, 0, -1, dp);
        
    }
}

/*
longest
strictly 
increasing
subsequence

1.since we need subsequence, 

    can't sort to get longest increasing ...
    
2. For any element, considering it opens up and simultaneosly closes down 
    possibilities for increasing subsequences... 
    
3. Thinking closely boils this question down to include exclude problem with 
    another condition(checking increasing) 
    
    */