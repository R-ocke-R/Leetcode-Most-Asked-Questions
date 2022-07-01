class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        //Approach 2: using no extra space, Trick: start filling nums1 in decreasing order from last
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j])
            nums1[k--]=nums1[i--];
            else nums1[k--]=nums2[j--];
            
        }
        // if nums1 elements are left after this with condition while(i>=0)
        // they are at there right place. cos of sorted nums1
        //but have to consider it for num2
        
        while(j>=0){
            nums1[k--]=nums2[j--];
        }        
    }
}