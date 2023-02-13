// class Solution {
//     public int strStr(String haystack, String needle) {
//         // brute:
//         for(int i=0;i<haystack.length();i++){
//             char ch=haystack.charAt(i);
//             if(ch==needle.charAt(0)){
//                 for(int j=1;j<needle.length();j++){
//                     if(++i <haystack.length() && haystack.charAt(i)==needle.charAt(j)) continue;
//                     else break;                    
//                 }
                
//             }
//         }
//     }
// }
// class Solution{
//     public int strStr(String haystack, String needle) {
//         // empty needle appears everywhere, first appears at 0 index
//         if (needle.length() == 0)
//             return 0;
//         if (haystack.length() == 0)
//             return -1;
        
        
//         for (int i = 0; i < haystack.length(); i++) {
//             // no enough places for needle after i
//             if (i + needle.length() > haystack.length()) break;
            
//             for (int j = 0; j < needle.length(); j++) {
//                 if (haystack.charAt(i+j) != needle.charAt(j))
//                     break;
//                 if (j == needle.length()-1)
//                     return i;
//             }
//         }
        
//         return -1;
//     }
// }

class Solution{
    public int strStr(String haystack, String needle){
        // empty needle
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        
        for(int i=0;i<haystack.length();i++){
            if(i+needle.length()>haystack.length()) break;
            
            for(int j=0;j<needle.length();j++){
                if(needle.charAt(j)!=haystack.charAt(i+j)) break;
                if(j==needle.length()-1) return i;
            }
        }
        return -1;
    }
}