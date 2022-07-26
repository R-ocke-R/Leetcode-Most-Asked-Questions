
class Solution {
    
    public boolean checkEqual(int[] count , int[] count2){
        int i=0;
        while(i<26){
            if(count[i]!=count2[i]){
                return false;
                
            }
            i++;
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        //Love's approach
        
        //count freq in string s2 which have all lowercase english characters
        int[] freq= new int [26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-97]+=1;
        }
        
        //now we will traverse through s1 with the same window size as s2.size()
        // and compare the freq of the window 
        int i=0;
        int window=s1.length();
        int[] freq2=new int[26];
        
        while(i<window && i<s2.length()){
            freq2[s2.charAt(i)-97]+=1;
            i++;
        }
        if (checkEqual(freq, freq2)){
            return true;
        }
            //move forward with the window.
            
        while( i< s2.length()){
            freq2[s2.charAt(i)-97]+=1;
            freq2[s2.charAt(i-window)-97]-=1;
            i++;
            if(checkEqual(freq, freq2)) return true;
        }
        return false;
    }
}