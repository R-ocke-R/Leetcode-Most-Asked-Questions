class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int value = binarySearch(nums, target, start, end);
        // return new int[]{value, value};
        // for left most value.
        int leftmost = value;
        int rightmost = value;
        while(value !=-1){
            leftmost = value;
            value = binarySearch(nums, target, start, value-1);

        }
        value = rightmost;
        while(value != -1){
            rightmost = value;
            value =binarySearch(nums, target, value+1, end);

        }
        return new int[]{leftmost, rightmost};

    }
    public int binarySearch(int[] nums, int target, int start , int end){
        while(start <= end){
            int mid = start + (end - start) /2;
            if(nums[mid] == target) return mid;
            if(nums[mid]>target) end=mid-1;
            else start = mid+1;
        }
        return -1;
    }
}