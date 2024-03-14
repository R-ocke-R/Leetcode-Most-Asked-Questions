class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        for(int i = 0 ; i< nums.length; i++){
            int currSum = 0;
            for (int j = i ; j < nums.length ; j++){
                currSum +=nums[j];
                // if goal reached 
                // count ++; continue;
                if (currSum == goal) {
                    count ++;
                    continue;
                }
                // if goal is excedded;
                // can't make more array with i
                // break;
                if(currSum > goal){
                    break;
                }

                // if goal not reached continue 
                if(currSum < goal){
                    continue;
                }

            }
        }
        return count;
    }
}