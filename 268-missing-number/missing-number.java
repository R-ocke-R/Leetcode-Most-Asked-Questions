class Solution {
    public int missingNumber(int[] nums) {
        // two optimised approaches. 
        // 1) xor 2) sum of first n elements
        int sum = nums.length;
        for(int i = 0; i< nums.length; i++){
            sum ^= nums[i];
            sum ^= i;
        }
        return sum;
    }
}