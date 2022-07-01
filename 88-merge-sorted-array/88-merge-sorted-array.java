class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int[] nums3=new int[m];
//         one approach is to have O(n+m) space or rather O(n) space
//         other involve
        while(i<m){
            nums3[i]=nums1[i];
            i++;
            
        }
        i=0;
        int k=0;
        while(i<n && j<m){
            if (nums2[i]<nums3[j]){
                nums1[k++]=nums2[i++];
            }
            else{
                nums1[k++]=nums3[j++];
            }
        }
        while(i<n){
            nums1[k++]=nums2[i++];

        }
        while(j<m){
            nums1[k++]=nums3[j++];

        }
        
        
    }
}