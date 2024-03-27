class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while(fast != slow );

        fast = nums[0];

        while(fast != slow ){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}

//* This is a classic question with 7 approaches in the editorial; have read most of the appraoches
// some good ones to cover the next time are: binary search, sum of bits, hashmap technique both rec + iter
