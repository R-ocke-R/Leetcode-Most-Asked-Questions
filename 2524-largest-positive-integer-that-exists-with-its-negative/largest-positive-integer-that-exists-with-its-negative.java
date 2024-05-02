class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set  = new HashSet<>();
        int numMax = -1;
        for(int i = 0; i < n; i++){
            // add to set
            set.add(nums[i]);
            // check if its counterpart exists
            int num = nums[i];
            
            if(set.contains(num*-1)) numMax = Math.max(numMax, Math.abs(num));
            
        }
        
        
        return numMax;
    }
}