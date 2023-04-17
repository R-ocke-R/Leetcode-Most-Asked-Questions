class Solution {
    public int recursive(int[] nums1, int[] nums2, int index, boolean swapped){
        // base
        if(index==nums1.length) return 0;
        
        // function
        // need previous 1 and 2 for comparing before swapping.
        int prev1=0;
        int prev2=0;
        if(index==0) {
            prev1=-1;
            prev2=-1;
        }
        else{
            prev1=nums1[index-1];
            prev2=nums2[index-1];
        }
        
        if(swapped) 
        {
            int swap=prev1;
            prev1=prev2;
            prev2=swap;
        }
        
        // don't swap
        int mini=Integer.MAX_VALUE;
        if(nums1[index] > prev1 && nums2[index] > prev2) mini=recursive(nums1, nums2, index+1, false);
        // swap
        else mini=Math.min(mini, 1+recursive(nums1, nums2, index+1, true));
        
        return mini;
        
    }
    public int memo(int[] nums1, int[] nums2, int index, int swapped, int[][] dp){
        if(index==nums1.length) return 0;
        
        if(dp[swapped][index]!=-1) return dp[swapped][index]; 
        // function
        // need previous 1 and 2 for comparing before swapping.
        int prev1=0;
        int prev2=0;
        if(index==0) {
            prev1=-1;
            prev2=-1;
        }
        else{
            prev1=nums1[index-1];
            prev2=nums2[index-1];
        }
        
        if(swapped==1) 
        {
            int swap=prev1;
            prev1=prev2;
            prev2=swap;
        }
        
        // don't swap
        int mini=Integer.MAX_VALUE;
        if(nums1[index] > prev1 && nums2[index] > prev2) mini=memo(nums1, nums2, index+1, 0, dp);
        // swap
        if(nums1[index] > prev2 && nums2[index] > prev1) mini=Math.min(mini, 1+memo(nums1, nums2, index+1, 1, dp));
        dp[swapped][index]=mini;
        return mini;
    }
    public int minSwap(int[] nums1, int[] nums2) {
        // return recursive(nums1, nums2, 0, false);
        // RECUSIVE SOLUTION -> TLE
        
        int[][] dp = new int[2][nums1.length];
        
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        // since I can't make a 2D nested array of integer-boolean. 
        // so going with a int[][] array, and to compliment it swapped is also of the type int
        // 0index is false and 1index is true
        return memo(nums1, nums2, 0, 0, dp);
    }
}


/*
is the second if statement in the body really needed.
you sure you understand if Swapped statement.



second if is needed other wise we are swapping for all indexes.
still not clear why. GOTTA UNDERSTAND IT BY DRY RUNNING IT MORE.

okay
question was that why we cannot swap for all indexes given that an answer is always possible....



thought an answer is always possible if we swap at all places, we may swap for places where no swap was NEEDED thus in THEORY  at those places the swap will actually distrupt the strictly increasing order. and our answer was not accepted coz of the same reason, somewhere the order may have been distrupted and future swaps which were actually needed were then avoided and our SUBMITTION 3 was rejected on the testcase.
*/