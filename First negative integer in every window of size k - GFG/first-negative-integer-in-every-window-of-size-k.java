//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Integer> queue= new LinkedList<>();
        
        // generating queue for the first window.
        for(int i=0;i<K;i++){
            if(A[i]<0) queue.add(i);
        }
        
        // System.out.println(queue);
        
        
        long[] ans=new long[N-K+1];
        int index=0;
        // Setting answer for the first index.
        if(queue.size()==0) ans[index]=0;
        else ans[index]=A[queue.peek()];
        index++;
        
        
        for(int i=K;i<N;i++){
            // remove from the front if its out of window
            if(queue.size()!=0 && i - queue.peek() >=K) queue.remove();
            // add A[i] if its negative.
            if(A[i]<0) queue.add(i);
            //ans update
            if(queue.size()==0) ans[index]=0;
            else ans[index]=A[queue.peek()];
            index++;
        }
        return ans;
        
    }
}