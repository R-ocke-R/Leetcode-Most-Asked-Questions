class Solution {
    public int subarraysDivByKBrute(int[] nums, int k) {
        
        int n = nums.length;
        int count = 0;
        int currSum = 0;

        for(int i = 0; i < n; i++){
            currSum = 0;
            for(int j = i; j < n; j++){
                currSum += nums[j];
                if(currSum % k == 0){
                    count++;
                }
            }
        }
        return count;
    }
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        int count = 0;
        int currSum = 0;
        
        // since I am stoing the remainder which will range from  0 to k 
        // i can use a array instead of a hashmap
        int[] map  = new int[k];
        map[0] = 1;
        // stores count of each index which represents remainder.
        for(int i = 0; i < nums.length; i++){
            currSum = (currSum + nums[i] % k + k) % k; 
            count += map[currSum];
            map[currSum]++;
        }
        return count;
    }
}

/** Lovely train of thought for this question. 
and neetcode.io explains it so ducking well jeezz.

Neetcode's chain of thought + Previous understanding of prefix sum tells me to use hashmap to store
but when I tried to check map.containsKey. I got a blocker as to where to go from there what value to check
there are many subarray's I can form and check.

That's where neetcode's video helped. do check it out.

 */