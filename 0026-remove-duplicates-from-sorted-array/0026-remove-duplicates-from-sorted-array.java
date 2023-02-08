class Solution {
    public int removeDuplicates(int[] nums) {
        int index=1;
        int n=nums.length;
        
        for(int i=1;i<n;i++){
            if(nums[i-1]!=nums[i]) nums[index++]=nums[i];
        }
        return index;
        
    }
}