class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        // find the best subarray of length == minutes
        int start = 0; // start of best index 
        int maxSub = 0; // sum of the best subarray

        int currSum = 0;
        for(int i = 0; i< minutes; i++){
            if(grumpy[i] == 1) currSum += customers[i];
        }
        maxSub = currSum;
        
        for(int i = minutes; i < n; i++ ){
            if(grumpy[i-minutes] == 1) currSum -= customers[i-minutes];
            if(grumpy[i] == 1) currSum += customers[i];

            if(currSum > maxSub) {
                // update the new max constant size subarray
                start = i;
                maxSub = currSum;
            }
        }

        int normalSum = 0;
        for(int i = 0; i< n; i++){
            if(grumpy[i]==0) normalSum += customers[i];
        }
        // for(int i = start ; i< minutes; i++){
        //     if(grumpy[i]==0) normalSum -= customers[i];
        // }
        return normalSum+maxSub;
    }
}