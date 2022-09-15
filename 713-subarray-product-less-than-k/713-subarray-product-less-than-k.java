class Solution {
    
    
//     this approach wasn't for contingous subarray, and its not even necessary right now.
//     public void subarrayRecursive(int[] nums, int index){
//         if(index==nums.length){
//             //print the subarray formed.
//         }
//         for(int i=index, i<nums.length;i++){
            
//         }
//     }
//     public int numSubarrayProductLessThanK(int[] nums, int k) {
//         //another question on sliding window technique, quite important for understanding all questions around subarrays and stuff.
//         int l=nums.length;
//         if(l<=1) return 0;
    
//         int count=0;
//         for(int i=0;i<l;i++){
//             int prod=nums[i];
//             if(prod<k) count++;
//             for(int j=i+1;j<l && prod<k;j++){
//                 prod*=nums[j];
//                 if(prod<k) count++;
//             }
//         }
//         return count;
//     }
    public int numSubarrayProductLessThanK(int[] nums, int k){
        if(k<=1) return 0;
        int count=0;
        int left=0;
        int prod=1;
        for(int r=0;r<nums.length;r++){
            prod*=nums[r];
            while(prod>=k){
                prod/=nums[left++];
                           }
            count+=r-left+1;
        }
        return count;
    }
}