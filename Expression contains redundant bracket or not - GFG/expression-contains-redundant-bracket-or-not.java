//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String string) {
        
        Stack<Character> s= new Stack<>();
        for(int i=0;i<string.length();i++){
            char ch=string.charAt(i);
            //if ch is character -> ignore
            
            //if ch is opening bracket or if ch is operator ->
            if(ch=='(' || ch =='+' || ch=='-' || ch=='/' || ch=='*')
            {
                s.push(ch);
            }
            
            
            // if ch is closing bracket
            if(ch==')'){
                if(s.peek()=='('){
                    return 1;
                }
                
                while(s.peek()!='('){
                    s.pop();
                
                }  
                s.pop();
            }
            
            
            
        }
        return 0;
        
    }
}
        
