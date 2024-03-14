class Solution {
    public int maxSubArray(int[] nums) {
        return kadane(nums);
    }
    public int printallsubarray(int[] nums, int index, int currSum, int maxSum){
        // recursive function 
        // base case
        if(index == nums.length){
            maxSum = Math.max(currSum, maxSum);
            // System.out.println(maxSum);
            return maxSum;
        }

        // include sum and call
        currSum += nums[index];
        maxSum = printallsubarray(nums, index +1, currSum, maxSum );
        currSum -= nums[index];

        
        // exclude sum and call
        maxSum = printallsubarray(nums, index +1, currSum, maxSum );
        return maxSum;
    }
    public int subarray(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int currSum = 0;
            for(int j = i; j < nums.length; j++){
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
    public int kadane(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i =0; i< nums.length;i++){
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            // this is cool till now, but I will carry forward the curr sum only when its positive and can add value
            if(currSum <0){
                currSum =0;
            }
        }
        return maxSum;
    }
}