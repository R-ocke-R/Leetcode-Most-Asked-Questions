class Solution {
    public int numSubarrayProductLessThanKBrute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int prod = 1;

        // brute
        for(int i = 0; i < n ; i++){
            prod = 1;
            for(int j = i; j < n; j++){
                int val  = nums[j];
                prod *=val;
                if(prod < k) count ++;
            }
        }
        return count;
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int n = nums.length;
        int count = 0;
        int prod = 1;

        int right = 0;
        int left = 0;
        while(right < n){
            int val = nums[right];

            prod *= val;
            while(prod >= k && left <= right){
                int value = nums[left];
                prod /=value;
                left ++;
            }

            if(prod < k ) count += right -left +1;
            right ++;
        }
        return count;
    }
    

}