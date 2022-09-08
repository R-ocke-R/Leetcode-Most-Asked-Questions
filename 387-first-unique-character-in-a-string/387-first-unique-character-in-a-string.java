class Solution {
    public int firstUniqChar(String s) {
        // have a variable to store the first unique character for all alphabets
        int ans=Integer.MAX_VALUE;
        int dum=-1;
        for(char i='a';i<='z';i++){
//             for(int j=0;j<s.length;j++){
//                 //if count of char >1 ; break
//                 //else put its location in dummy
//                 //check if dum index is less than that of any other char(stored in ans);
                
//             }
            int index=s.indexOf(i);
            if(index!=-1 && index==s.lastIndexOf(i)){
                ans=Math.min(ans, index);
            }
            
            
        }
        
        return ans==Integer.MAX_VALUE? -1:ans;
    }
}