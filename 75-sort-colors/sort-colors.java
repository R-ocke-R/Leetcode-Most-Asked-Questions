class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]= temp;
    }
    public void sortColors(int[] nums) {
        // we have 0's and 1's and 2's .
        int n=nums.length;
        int zero =0;
        int two = n-1;
        for(int index = 0; index <= two; index++){
            if(nums[index]==0 && index != zero){
                // this means we have the next zero that needs to go 
                // at its place which is defined by the variable zero.
                swap(nums, index, zero);
                zero++;index--;
            }
            else if(nums[index]==2){
                // again we have two cases when we encounter the next 2 in 
                // the array, either we need to swap it with the element that is at
                // variable index two. or if we have reached the index denoted by 
                // two, we have solved the problem.
                swap(nums, index, two);
                two--;index--;
            }
        }
    }
}