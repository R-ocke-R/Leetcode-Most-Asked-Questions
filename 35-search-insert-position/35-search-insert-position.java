class Solution {
    public int searchInsert(int[] nums, int target) {
        int s=0;int e=nums.length-1;
        int mid;
        while(s<=e) {
            
            mid=s+(e-s)/2;
            
            if(target==nums[mid]) return mid;
            if(target>nums[mid]) s=mid+1;
            else e=mid-1;
            
            
        }
        return s;
    }
}