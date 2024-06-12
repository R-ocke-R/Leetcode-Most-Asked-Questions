class Solution {
    public boolean checkSubarraySumBrute(int[] nums, int k) {
        int n = nums.length;

        int currSum = 0;

        for(int i = 0; i < n; i++){
            currSum = nums[i];
            for(int j = i+1; j < n; j++){
                currSum += nums[j];
                if(currSum % k == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkSubarraySum(int[] nums, int k){
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        int preSum = 0;

        map.put(0, -1);

        for(int i = 0; i < n; i++){
            preSum = (preSum + nums[i]) % k;

            if(map.containsKey(preSum)){
                if( i - map.get(preSum) > 1){
                    return true;
                }
            }else {
                    // mark the current index
                    map.put(preSum, i);
                }
            }
        return false;
        }
    
}

/**
Brute - generated all the subarrays in O(n^2) time complexity, gave TLE.

Optimisation though - in this question there is no way we can optimise it without an hashmap, 
as an simple left-right sliding window will not work due to the underlying condition.\

 */