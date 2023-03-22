//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int recursive(int n, int x, int y, int z){
        //base case
        if(n==0) return 0;
        if(n<x && n<y && n<z) return Integer.MIN_VALUE;
        
        // for x
        int Xways=recursive(n-x, x, y, z)+1;
        
        // for y
        int Yways=recursive(n-y, x, y, z)+1;
        
        // for z
        int Zways=recursive(n-z, x, y, z)+1;
        
        return Math.max(Xways, Math.max(Yways, Zways));
        
    }
    public int memo(int n ,int x, int y, int z, int[] dp){
        
        if(n==0) return 0;
        
        if(n<x && n<y && n<z) return Integer.MIN_VALUE;
        if(dp[n]!=-1) return dp[n];
        // for x
        int Xways=memo(n-x, x, y, z, dp)+1;
        
        // for y
        int Yways=memo(n-y, x, y, z, dp)+1;
        
        // for z
        int Zways=memo(n-z, x, y, z, dp)+1;
        dp[n]=Math.max(Xways, Math.max(Yways, Zways));
        return dp[n];
    }
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int[] dp= new int[n+1];
        Arrays.fill(dp, -1);
       int result=memo(n, x, y, z, dp);
       if(result<0) return 0;
       return result;
    }
}
