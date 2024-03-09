class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
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
}