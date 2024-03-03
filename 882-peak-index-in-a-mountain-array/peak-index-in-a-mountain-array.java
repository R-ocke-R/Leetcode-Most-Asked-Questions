class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return binary_search(arr);
    }
    public int binary_search(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start + (end - start)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid+1] > arr[mid]) start = mid+1;
            else end = mid;
        }
        return -1;
    }
}