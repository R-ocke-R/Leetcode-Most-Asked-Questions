class Solution {
    
    public int compress(char[] chars) {
        int i=0;
        //for iteration
        
        int ans=0;
        //final answer
        
        int n=chars.length;
        //
        
        while(i<n){
            int count=1;

            
            while(i+1<n && chars[i]==chars[i+1]){
                i++;
                count++;
            }
            chars[ans++]=chars[i];     //add the character.
            
            if(count>1){
                // ans+=function(count);
                
                String cnt=Integer.toString(count);
                for(int j=0;j<cnt.length();j++){
                    chars[ans++]=cnt.charAt(j);
                }
            }
            i++;
        }
        return ans;
        
        
    }
}