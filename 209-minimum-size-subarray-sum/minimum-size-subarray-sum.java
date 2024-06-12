class Solution {
    public int minSubArrayLenBrute(int target, int[] nums) {
        int n = nums.length;

        int currSum = 0;
        int miniLen = Integer.MAX_VALUE;

        for(int i = 0; i< n; i++){
            currSum = 0;
            for(int j = i; j < n; j++){
                currSum += nums[j];
                //System.out.println(miniLen);
                if (currSum >= target) {
                    miniLen = Math.min(miniLen, j-i+1);
                    //System.out.println(miniLen);
                }
            }
        }
        return miniLen == Integer.MAX_VALUE ? 0 : miniLen;
        
    }
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int currSum = 0;
        int miniLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        while(right < n){
            currSum += nums[right];
            if (currSum >= target) {
                miniLen = Math.min(miniLen, right-left+1);
                // try to reduce the size?
                while(currSum >= target && left <= right){
                    miniLen = Math.min(miniLen, right-left+1);
                    currSum-= nums[left++];
                }
            }
            right++;
        }
        return miniLen == Integer.MAX_VALUE ? 0 : miniLen;
        
    }
}
