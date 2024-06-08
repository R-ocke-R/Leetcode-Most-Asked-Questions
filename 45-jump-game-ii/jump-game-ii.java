class Solution {
    public int recursive(int[] nums, int index){
        if(index >= nums.length-1) return 0;
        int count = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[index]; i++){
            count = Math.min(count, recursive(nums, index+i));
        }
        if(count == Integer.MAX_VALUE) return count;
        return count+1;
    }
    public int jump(int[] nums) {
        // return recursive(nums, 0);
        // this is greedy optimisation of the recursion + DP approach 
        int l = 0;
        int r = 0;

        int jumps = 0;
        
        while(r < nums.length-1){
            int farthest = 0;
            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            l = r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }   
}