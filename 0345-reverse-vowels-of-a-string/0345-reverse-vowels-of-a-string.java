class Solution {
    boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
            || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }
    
    void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }
    
    public String reverseVowels(String s) {
        int start = 0;
        int end  = s.length() - 1;
        char[] sChar = s.toCharArray();
        
        while (start < end) {

            while (start < s.length () && !isVowel(sChar[start])) {
                start++;
            }
            // Find the rightmost vowel
            while (end >= 0 && !isVowel(sChar[end])) {
                end--;
            }
            // Swap them if start is left of end
            if (start < end) {
                swap(sChar, start++, end--);
            }
        }
        
        // Converting char array back to String
        return new String(sChar);
    }
//     public String reverseVowels(String s) {
//         int i=0; int j=s.length()-1;
        
//         char[] arr=s.toCharArray();
        
//         while(i<j){

//             while(i<j && !(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u')){
//                 i++;
//             }
            
//             if(i>=j) break;
            
            
//             while(i<j && !(arr[j]=='a' || arr[j]=='e' || arr[j]=='i' || arr[j]=='o' || arr[j]=='u')){
//                 j--;
//             }
            
            
//             if(i>=j) break;
            
//             // swap
//             char first=arr[i];
//             arr[i]=arr[j];
//             arr[j]=first;
//             i++;
//             j--;
            
//         }
//         // System.out.println(i+" "+j);
//         return new String(arr);
//     }
}
/* 
first since string is immutable so convert to char array or use stringBuffer

First Intuition 

2 pointer appraoch 
*/