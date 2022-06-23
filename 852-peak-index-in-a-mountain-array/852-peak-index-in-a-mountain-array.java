class Solution {
//     public int peakIndexInMountainArray(int[] arr) {
// //         ofcourse the O(n) solution is very simple and straight forward
//         int i=0;
//         while (true){
//             if(arr[i++]>arr[i]){
//                 break;
//             }
//         }
//         return --i;
//     }
    public int peakIndexInMountainArray(int[] arr){
//         now attempting to implement a logarithmic solution, by modifying BS
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=s+((e-s)/2);
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[mid-1]<arr[mid]){
                s=mid+1;
            }
            else{
                e=mid;
            }
            
        }
        return -1;
    }
}