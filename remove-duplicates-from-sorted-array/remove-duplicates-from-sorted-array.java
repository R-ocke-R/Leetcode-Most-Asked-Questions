class Solution {
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public int removeDuplicates(int[] nums) {
        int index=0;
        int i=0;
        int n=nums.length;
        while(i<n){
            int count=1;
            while(i+1<n && nums[i]==nums[i+1]){
                count++;
                i++;
            }
            // by now I have the count of nums[i] 
            // but I only need one 
            nums[index++]=nums[i];
            i++;
        }
        return index;
        
    }
}