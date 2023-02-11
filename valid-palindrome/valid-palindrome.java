class Solution {
    public boolean isPalindrome(String s) {
        String str=new String();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                str+=Character.toLowerCase(ch);
            }
        }
        if(str.length()<2) return true;
        int a=0; int z=str.length()-1;
        while(a<z){
            if(str.charAt(a)!=str.charAt(z)) return false;
            a++; z--;
        }
    return true;
    }
}