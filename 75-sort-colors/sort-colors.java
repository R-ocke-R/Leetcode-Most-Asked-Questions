class Solution {
    public void swap(int[] nums, int i, int j){
        int temp  = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
        return;
    }
    public void sortColors(int[] nums) {
        // DNF
        // brute sort
        // better count and replace. - two pass solution + constant space
        // best approach is using DNF technique. 

        int n = nums.length;
        int left = 0;
        int right = n-1;

        int index = 0;

        while(index <= right){
            if(nums[index] == 0){
                // no swap needed
                if(index!=left) swap(nums, left, index);
                left++;
                index++;
                
            }
            else if(nums[index] == 1){
                //swap(nums, left, index);
                // left remains the same as it indicates the end of zero
                index++;
            }
            else{
                swap(nums, right, index);
                // index remains the same.
                right --;
            }
            System.out.println(Arrays.toString(nums));
        }
        
    }
}