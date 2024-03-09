class Solution {
    public int getCommonBrute(int[] nums1, int[] nums2) {
        int n =nums1.length;
        int m = nums2.length;

        for(int i =0;i<n;i++){
            int ele = nums1[i];
            // we find this ele in nums. we find it we return as nums1 is sorted in non dec.
            int j=0;
            while(j<m && nums2[j]<=ele){
                if(nums2[j]==ele ) return ele;
                j++;
            }
        }
        return -1;
    }
    public int getCommonBetter(int[] nums1, int[] nums2){
        // how can I improve the code above. j is running from 0 each time. not needed. 
        int n =nums1.length;
        int m = nums2.length;
        int j=0;
        
        for(int i=0;i<n;i++){
            int ele = nums1[i];
            // we find this ele in nums. we find it we return as nums1 is sorted in non dec.
            while(j<m && nums2[j]<=ele){
                if(nums2[j]==ele ) return ele;
                j++;
            }
        }
        return -1;
    }
    public boolean binarySearch(int[] arr, int ele){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==ele) return true;
            else if(arr[mid]>ele) end = mid-1;
            else start = mid+1;
        }
        return false;
    }
    public int getCommonBS(int[] nums1, int[] nums2){
        if(nums1.length>nums2.length) return getCommonBS(nums2, nums1);

        // iterate the smaller array

        for(int ele : nums1){
            if(binarySearch(nums2, ele)) return ele;
        }

        return -1;
    }
    public int getCommon(int[] nums1, int[] nums2){
        return getCommonBS(nums1, nums2);
    }
}
