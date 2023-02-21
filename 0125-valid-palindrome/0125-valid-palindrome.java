class Solution {
    // public boolean isPalindrome(String s) {
    //     String str=new String();
    //     for(int i=0;i<s.length();i++){
    //         char ch=s.charAt(i);
    //         if(Character.isLetterOrDigit(ch)){
    //             str+=Character.toLowerCase(ch);
    //         }
    //     }
    //     if(str.length()<2) return true;
    //     int a=0; int z=str.length()-1;
    //     while(a<z){
    //         if(str.charAt(a)!=str.charAt(z)) return false;
    //         a++; z--;
    //     }
    // return true;
    // }
// this uses extra space, optimize it without using a new str. but still a two pointer is possible.
    public boolean isPalindrome(String s){
        if(s.length()==1) return true;
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            

            while(i<=j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }

            while(i<=j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            
            if(i<=j && Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) return false;  
            i++; j--;
        }
        return true;
    }
}
