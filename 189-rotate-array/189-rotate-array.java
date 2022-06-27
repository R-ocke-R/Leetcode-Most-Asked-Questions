import java.util.*;
class Solution {
//     public void rotate(int[] nums, int k) {
// //         first : the places are decided by k not by rotating.
        
//         int n=nums.length;
//         int j=0;
//         // System.out.println(k%n);
//         while(j<(k%n)){
//             int temp=nums[n-1];
//             for(int i=n-1;i>0;i--){
//                 nums[i]=nums[i-1];
//             }
//             nums[0]=temp;
//             j++;
//         }
//         // System.out.println(Arrays.toString(nums));
//     }
//     public void rotate(int[] nums, int k){
// //         second using k to determine indexes, O(n) solution for both space+time
//         int[] arr= new int [nums.length];
//         k=k%arr.length;
//         int j=0;
//         for(int i=k+1;i<nums.length;i++){
//             arr[j++]=nums[i];
//         }
        
//         for(int i=0;i<=k;i++){
//             arr[j++]=nums[i];
//         // }System.out.println(Arrays.toString(arr));
//         }
//         for(int i=0;i<arr.length;i++){
//             nums[i]=arr[i];
//         }

        
//         // return arr;
//     }
    public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

    public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
    
    
}