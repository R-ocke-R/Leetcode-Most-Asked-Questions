// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}// } Driver Code Ends




class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        int[] freq= new int[26];
        int ch;
        for(int i=0;i<line.length();i++){
            ch=line.charAt(i);
            if(ch>=97 && ch<=122){
                freq[ch-97]+=1;
            }
            else if(ch>=65 && ch<=90){
                freq[ch-65]+=1;
            }
        }
        int m=0;
        
        for(int i=0;i<26;i++){
            if(freq[i]>freq[m]){
                m=i;
            }
        // }System.out.println(m);
        }
        return (char)('a'+m);
    }
    
}