import java.util.*;
class Solution {
//     Approach 1: Solving with formuale using O(N) time and space complexity,
    
    // public void rotate (int [] arr, int k){
    //     int[] temp=new int[arr.length];
    //     for(int i=0;i<arr.length;i++){
    //         temp[(i+k)%arr.length]=arr[i];
    //     }
    //     for(int i=0;i<arr.length;i++){
    //         arr[i]=temp[i];
    //     }
    // }    
//     Approach 2: Solving with a O(n) time and O(1) space complexity,
    public void rotate(int[] arr, int k){
        k=k%arr.length;
        rr(arr, 0, arr.length-1);
        rr(arr, 0, k-1);
        rr(arr, k, arr.length-1);
            
    }
    public void rr(int[] arr, int s, int e){
        while(s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
            
        }
    }
}