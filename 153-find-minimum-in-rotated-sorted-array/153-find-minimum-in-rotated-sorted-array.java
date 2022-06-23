class Solution {
    public int findMin(int[] nums) {
//         first implementation
//         thinking to use nums[0] in a binary search.
        int target=nums[0];
        int s=0;
        int e=nums.length-1;
        int mid=s+((e-s)/2);
        while(s<e){
            if(nums[mid]>=target){
                s=mid+1;
            }
            else{
                e=mid;
            }
            mid=s+((e-s)/2);
        }
        if(nums[s]<target){
            return nums[s];
        }
        return target;

        
    }
}