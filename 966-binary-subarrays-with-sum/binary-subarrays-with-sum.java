class Solution {
    public int numSubarraysWithSumBrute(int[] nums, int goal) {
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
    public int numSubarraysWithSum(int[] nums, int goal){
        return numSubarraysWithLessSum(nums, goal) - numSubarraysWithLessSum(nums , goal - 1);
    }
    public int numSubarraysWithLessSum(int[] nums, int goal){
        if(goal < 0 ) return 0;
        int n = nums.length;
        int count = 0;
        int currSum = 0;

        int left = 0;
        int right = 0;

        while( right < n ){
            int val = nums[right];

            currSum += val;

            while(currSum > goal){
                currSum  -= nums[left++];
            }

            count += right - left + 1    ;

            right ++;

        }


        return count;
    }
    // public int numSubarraysWithSum(int[] nums, int goal){

    // }
}