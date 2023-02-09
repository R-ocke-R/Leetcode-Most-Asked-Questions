class Solution {
    public void swap(int[] nums, int i , int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void moveZeroes(int[] nums) {
        // if(nums.length==1) return ;
        int digitsIndex=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums, i, digitsIndex++);
            }
        }
        return ;
    }
}