class Solution {
    public int findMin(int[] nums) {
///condition of no rotations
        if(nums[0]<nums[nums.length-1]) return nums[0];
        
        int s=0;
        
        int e=nums.length-1;
        int m= s+((e-s)/2);
        while(s<e){
        if(nums[m]>=nums[0]){
            s=m+1;
        }
            
        
            else{
                e=m;
                
            }
            m=s+((e-s)/2);
        }
        return nums[s];
        
    }
}