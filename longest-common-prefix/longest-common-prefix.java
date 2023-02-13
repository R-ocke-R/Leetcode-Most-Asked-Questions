class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Brute:
        // first thing is to calculate the minimim length among all the strings.
        int n=strs.length;
        int minimum=strs[0].length();
        
        for(int i=0;i<n;i++){
            minimum=Math.min(minimum, strs[i].length());
        }
        String prefix=new String();
        for(int i=0;i<minimum;i++){
            char current=strs[0].charAt(i);
            for(int j=0;j<n;j++){
                if(current!=strs[j].charAt(i)) return prefix;
            }
            prefix+=current;
        }
        return prefix;
       
//         int maxlength=0;
//         String prefix=new String();
        
        
        
//         for(int i=0;i<minimum)
    }
}