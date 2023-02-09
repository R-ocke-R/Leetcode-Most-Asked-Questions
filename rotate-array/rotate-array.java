class Solution {
    public void rotator(int[] nums, int i, int j){
        // rotates the array from index i to j, using two pointer approach
        while(i<=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;j--;
        }
    }
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        //nick white's approach
        rotator(nums, 0, nums.length-1);
        rotator(nums, 0, k-1);
        rotator(nums, k, nums.length-1);
        return ;
    }
}