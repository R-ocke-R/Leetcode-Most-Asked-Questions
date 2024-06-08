class Solution {
    public boolean canJump(int[] nums) {
        int reachAble = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            // System.out.println(reachAble);
            if(reachAble < i ) return false;
            reachAble = Math.max(reachAble, i + nums[i]);
        }
        return true;
    }
}