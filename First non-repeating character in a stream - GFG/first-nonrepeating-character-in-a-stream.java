//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        
        String ans="";
        int[] freq= new int[26];
        Queue<Character> queue= new LinkedList<>();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
           
           // increase its frequency in fre 
            freq[ch-97]++;
            
            queue.add(ch);
            
            while(!queue.isEmpty()){
                if(freq[(queue.peek()-97)]>1) queue.remove();
                else{
                    ans+=queue.peek();break;
                }
            }
            if(queue.isEmpty()) ans+='#';
           
       }
    //   System.out.println(Arrays.toString(freq));
    
       return ans;
    }
}