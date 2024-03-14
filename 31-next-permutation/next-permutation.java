class Solution {
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int start, int[] nums){
        int j = nums.length -1;
        while(start < j){
            swap(start, j, nums);
            start ++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while( i >= 0  && nums[i+1] <= nums[i]){
            i--;
        }
        // if we found an element before reaching the end of the array we need to now find j 
        if(i>=0){
            int j = nums.length -1;
            while(nums[j]<=nums[i]){
                // this will give you an element that is just bigger than nums[i];
                j--;
            }
            swap(i, j, nums);
        }
        // this will do the work of both cases, when i = -1, where it will swap full nums. and the other case 
        // it will reverse all elements after i index.
        reverse(i+1, nums);
        return ;
    }
}
 