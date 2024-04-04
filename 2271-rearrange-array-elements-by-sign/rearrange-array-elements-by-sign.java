class Solution {
    public int[] rearrangeArray(int[] nums) {
        // brute approach 
        int n = nums.length;
        int[] format = new int[n];

        int index = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) {
                // positive number
                format[index] = nums[i];
                index = index +2;
            }
        }
        index = 1;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0) {
                // positive number
                format[index] = nums[i];
                index = index +2;
            }
        }
        return format;
    }
}