class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxEle = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            maxEle = Math.max(maxEle, nums[i]);
        }
        int freq = 0;
        long count = 0;

        int right = 0;
        int left = 0;
        while(right < n){

            int val = nums[right];
            if(val == maxEle) freq ++;

            while(k == freq) {
                int value = nums[left++];
                if(value == maxEle) freq--;
            }
            // left window index value indicates the number of subarrays that can end at right 
            // as all those will have the condition satisfied. as left increase and move the right half
            // that indicates that any successful window formed will contribute a lot of subarray
            // that satisfy that condition where the subarray's will be from left(0 to n) -> right.
            count += left;
            right++;
        }
        return count;
    }
}