class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        /** solving this as a version of binary subarray sum k */

        // implementing the best approach. 

        int n = nums.length;
        int count = 0;
        int currSum = 0;

        int left = 0;
        int right = 0;
        int prefixZero = 0;

        while( right < n ){
            int val = nums[right];
            currSum += val % 2;
            
            // if currSum > goal
            while(left < right && (nums[left]%2 == 0 || currSum > k)){
                if(nums[left]%2 == 1){
                    prefixZero = 0;
                }
                else prefixZero ++;

                currSum -= nums[left++]%2;
            }
            // if currSum == goal

            if(currSum == k) count += 1 + prefixZero;
            

            right ++;
        }
        
        return count;
    }
}