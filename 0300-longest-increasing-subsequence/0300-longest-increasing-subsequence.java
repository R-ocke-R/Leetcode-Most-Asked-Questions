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
    
    public int tabulation(int[] nums){
        // Step 1: create DP and fill in the base cases.
        int n=nums.length;
        int[][] dp = new int[n+1][n+1];
        
        // base cases already 0
        
        // Step 2: bottom up!!
        for(int index=n-1; index>=0; index--){
            for(int prev=index-1; prev>=-1; prev--){
                int val = dp[index+1][prev+1];
                if(prev==-1 || nums[index]>nums[prev]) val= Math.max(val, 1+ dp[index+1][index+1]);
                dp[index][prev+1]=val;
            }
        }
        return dp[0][0];
    }
    
    public int bs(ArrayList<Integer> list, int num){
        int min = 0;
        int max = list.size()-1;
        
        while(min<=max){
            int mid = min + (max-min)/2;
            
            if(list.get(mid) < num){
                min = mid+1;
            }
            else max = mid-1;
        }
        return min;        
        
    }
    public int binarySearchDP(int[] nums){
        ArrayList<Integer> list= new ArrayList<>();
        
        for(int num : nums){
            
            if(list.size() == 0 || num > list.get(list.size()-1)){
                list.add(num);
            }
            else{
                int index = bs(list, num);
                list.set(index, num);
            }
        }
        return list.size();
    }
    
    
    public int lengthOfLIS(int[] nums) {
        // recursive gives TLE
        // return recursive(nums, 0, -1);
        
       // moving to memo 
        // int n = nums.length;
        // int[][] dp = new int[n][n+1];
        // return memo(nums, 0, -1, dp);
        // works yet slow
        
        // return tabulation(nums);
        
        return binarySearchDP(nums);
        
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