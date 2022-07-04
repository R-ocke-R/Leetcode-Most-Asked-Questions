class Solution {
    public boolean isPalindrome(String s) {
        
    
        String ss=new String();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i);
            if(Character.isLetter(ch)|| Character.isDigit(ch)){
                ss+=ch;
            }
        }
        int st=0;
        int e=ss.length()-1;
        while(st<e){
            if(Character.toLowerCase(ss.charAt(st++))!=Character.toLowerCase(ss.charAt(e--))){
                return false;
            }
        }
        return true;
    }
}