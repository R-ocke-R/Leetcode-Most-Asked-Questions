// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        if(n==1)return arr[0];
        int start= 0;
        int end= n-1;
        int midpoint=start+((end-start)/2);
        while(start<end){
            if(arr[midpoint]>=arr[0]){
                start=midpoint+1;
                
            }
            else
            {
                end=midpoint;
            }
            midpoint=start+((end-start)/2);
        }
        if (arr[start]>arr[0])
        {
            return arr[0];
        }
        return arr[start];
    }
}
