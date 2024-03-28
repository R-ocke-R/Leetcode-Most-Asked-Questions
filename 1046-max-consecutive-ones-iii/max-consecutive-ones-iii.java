class Solution {
    public int longestOnesBetter(int[] nums, int k) {
        // the brute approach asks to generate all the subsequence and check for the condition where zero's at most k
        // we aren't coding that, let's do the better approach using 2 pointers.
        int n = nums.length;

        // track the count of zeros
        int zero = 0;
        int maxL = 0;

        int left = 0;
        int right = 0;
        while(right < n ){
            int val = nums[right];

            if (val == 0){
                zero ++;
            }

            if( zero <= k ){
                // allowed number of zeros then expand the window
                maxL = Math.max(maxL, right - left +1);

            }
            else {
                // more zeros that allwoed so now we shrink the window 
                while(nums[left] != 0){
                    left ++;
                }
                // moved left window till the next 0 is found
                // remove one zero
                left ++;
                // remove its count
                zero --;
            }

            right ++;
        }
        return maxL;

    }
    public int longestOnes(int[] nums, int k ){
        /** the sliding window is O(2n), which can (in most cases) be optimised to O(n)
        
        the main logic is to find a way not to move left window linearly, rather find some way to move it in constant time
        here waht we can do is instead of moving left till we find zero and zero count condition is satisfied 
        we notice that since all we want is the longest subarray we don't need to shrink the window to a size
        lesser than the maximum size we have generated. but this will count the subarry with more zero than allowed
        
        sol- we only update max when zero's are in check.*/

        int n = nums.length;
        int zero = 0;
        int maxL = 0;

        int left = 0;
        int right = 0;
        while(right < n ){
            int val = nums[right];

            if (val == 0){
                zero ++;
            }

            if( zero <= k ){
                // allowed number of zeros then update maxL
                maxL = Math.max(maxL, right - left +1);

            }
            else {
                // more zeros that allwoed, but in this case we don't use the while loop
                //while(nums[left] != 0){ left ++; }
                // we rather move left and update zero accordingly
                if(nums[left]==0) zero --;
                left ++;
            }

            right ++;
        }
        return maxL;
    }
}