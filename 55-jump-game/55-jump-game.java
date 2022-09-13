class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1) return true;
        
        int Mindex=0;
        
        for(int i=0; i<n && Mindex>=i; i++){
            if(Mindex<i+nums[i]) Mindex=i+nums[i];
            
            if(Mindex>=n-1) return true;
            
        }
        return false;
        
    }
}
