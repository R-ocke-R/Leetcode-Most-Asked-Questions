class Solution {
    public boolean canJump(int[] nums) {
        
        int n=nums.length;
        int lastGoodIndex=n-1;
        for(int i=lastGoodIndex-1;i>=0;i--) {
            if(i+nums[i]>=lastGoodIndex) lastGoodIndex=i;
        }
    return lastGoodIndex==0;
    }
    
}