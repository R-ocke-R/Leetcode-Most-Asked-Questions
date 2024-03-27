class Solution {
    public int maxScore(int[] cardPoints, int k) {
        /** this question can be solved via 1) DP 2) sliding window
        tbh this is a very basic sliding window question,
        right now doing this as part of sliding window playlist by striver.  */
        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;
        int n = cardPoints.length;

        // first create complete left window 
        for(int i = 0 ; i < k ; i++){
            lsum += cardPoints[i];
        }

        if( n == k ) return lsum;

        maxSum = lsum;
        // then we shrink left window
        // whilest expading right window
        for(int i = 0; i < k ; i++ ){
            lsum -= cardPoints[k-i-1];
            rsum += cardPoints[n-i-1];
            maxSum = Math.max(lsum+rsum, maxSum);
        }

        return maxSum;
        
    }
}