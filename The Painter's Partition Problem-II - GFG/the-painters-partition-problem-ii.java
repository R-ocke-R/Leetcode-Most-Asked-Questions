// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

 class Solution{
    static boolean paint(long mid, int[] arr, int k){
        long boardPainted=0;
        long painter=1;
        for (int i = 0; i < arr.length; i++) {
            if(boardPainted+arr[i]<=mid){
                boardPainted+=arr[i];

            }
            else{
                painter++;
                if(painter>k || arr[i]>mid){
                    return false;
                }
                boardPainted=arr[i];
            }

        }
        return true;

    }
    static long minTime (int[] arr, int n, int k){
        long s=0;
        long e=0;
        // int ans=0;
        for (int index = 0; index < arr.length; index++) {
            e+=arr[index];
        }
        long mid=s+((e-s)/2);
        while(s<=e){
            if(paint(mid, arr, k)){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
            mid=s+((e-s)/2);
        }

        return (long)s;
    }
}


