// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 

{
    public static boolean func(int[] arr, int mid, int n, int m){
        int pageSum=0;
        int students=1;
        for(int i=0; i<arr.length;i++){
            if(pageSum+arr[i]<=mid){
                pageSum+=arr[i];
                
            }
            else{
                students+=1;
                if(students>m || arr[i]>mid){
                    return false;
                }
                pageSum=arr[i];
            }
        }
        return true;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int s=0;int e= 0;
        for(int i=0;i<A.length;i++){
            e+=A[i];
        }
        int mid=s+((e-s)/2);
        
        while(s<=e){
            if (func(A, mid, N, M)){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
            mid=s+((e-s)/2);
        }
        
        return s;
    }
};