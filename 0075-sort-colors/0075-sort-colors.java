class Solution {
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        // brute: count 0, 1, 2 create a new array

        // OP : count and swap in 
        
        // 2 pointer
        int index=0;
        int j=nums.length-1;
        for(int i=0;i<=j;i++){
            if(nums[i]==0 && index!=i){
                swap(nums, i--, index++);
            }
            else if(nums[i]==2){
                swap(nums, i--, j--);
            }
        }
        
    }
}