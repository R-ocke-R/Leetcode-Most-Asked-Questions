class Solution {
    public int[] singleNumber(int[] nums) {
        // coding the OG approach
        int xor = 0;
        for (Integer i : nums) xor^=i;
        // now we seperate the two number based on the right most set bit
        int right = (xor&(xor-1)) ^ xor;

        // to seperate we can just use for + if
        int on = 0;
        int off = 0;
        for(int i = 0; i < nums.length; i++){
            // if right bit is on 
            if((right & nums[i]) != 0) on ^=nums[i];
            // if right bit is off.
            else off ^= nums[i];
        }
        return new int[]{on, off};
    }
}