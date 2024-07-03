class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4 ) return 0;

        Arrays.sort(nums);

        int mindifference = Math.abs(nums[n-4] - nums[0]);
        mindifference = Math.min(mindifference, Math.abs(nums[n-3] - nums[1]));
        // removing the last 3 elements

        mindifference = Math.min(mindifference,Math.abs(nums[n-2] - nums[2]));

        mindifference = Math.min(mindifference,Math.abs(nums[n-1] - nums[3]));
        
        return mindifference;
    }
}