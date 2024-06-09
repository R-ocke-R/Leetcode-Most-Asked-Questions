class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        int maxSum = sum;
        if(k==n) return maxSum;
        for(int i = k-1; i >=0; i--){
            sum -= cardPoints[i];
            sum += cardPoints[--n];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}