class Solution {
    
    public int compress(char[] chars) {
        int i=0;
        int ans=0;
        int n=chars.length;
        while(i<n){
            int count=1;
            
            while(i+1<n && chars[i]==chars[i+1]){
                count++;
                i++;
            }
            chars[ans++]=chars[i];
            if(count>1){
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
