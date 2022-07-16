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
        int mid=s+((e-s)/2);
        while(s<e){
            mid=s+((e-s)/2);
            // System.out.println(mid+" "+s+" "+ e);
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid+1]>arr[mid]){
                 s=mid+1;
            }
            else{
                e=mid;
            }
            
        }
        return -1;
    }
}