//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    boolean knows(int M[][], int a, int b){
        if(M[a][b]==1) return true;
        return false;
        
    }
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> stack= new Stack<>();
    	for(int i=0;i<n;i++){
    	    stack.push(i);
    	}
    	while(stack.size()>1){
    	    int a=stack.pop();
    	    int b=stack.pop();
    	    
    	    if(knows(M,a, b)){
    	        stack.push(b);
    	    }
    	    else{
    	        stack.push(a);
    	    }
    	}
    	// this last element could or couldn't be a celebrity;
    	// so we must manually check and return -1 otherwise.
    	int ans=stack.pop();
    	int i=0;
    	while(i!=n){
    	    if(M[ans][i]!=0){
    	        return -1;
    	    }
    	    i++;
    	}
    	i=0;
    	int count=0;
    	while(i!=n){
    	    if(M[i][ans]==1){ count++;}
    	    i++;
    	}
    	if(count==n-1) return ans;
    	return -1; 
    	
    }
}