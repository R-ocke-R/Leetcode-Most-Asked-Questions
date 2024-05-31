class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(Integer x:nums) xor ^= x;

        int right = (xor&(xor-1))^xor;
        int onBucket = 0;
        int offBucket = 0;
        for(int i = 0; i < nums.length; i++){
            if((right&nums[i])!=0) onBucket^=nums[i];
            else offBucket^=nums[i];
        }
        return new int[]{onBucket, offBucket};
    }
}