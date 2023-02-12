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
class Solution{
    public int strStr(String haystack, String needle) {
  for (int i = 0; ; i++) {
    for (int j = 0; ; j++) {
      if (j == needle.length()) return i;
      if (i + j == haystack.length()) return -1;
      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    }
  }
}
}
