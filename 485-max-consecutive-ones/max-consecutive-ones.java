class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ones = -1;
        int index = 0;
        int maxL = 0;
        while(index < n){
            int val = nums[index];
            // if 0
            if(val==0) {
                index ++; continue;
            };
            // if 1
            ones = index;
            while(index < n && nums[index]==1){
                index ++;
            }
            maxL = Math.max(maxL, index-ones);
            index++;

        }
        return maxL;
    }
}