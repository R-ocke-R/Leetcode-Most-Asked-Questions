class Solution {
    public boolean isPalindrome(String s) {
        
    
        String ss=new String();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                ss+=Character.toLowerCase(ch);
            }
        }
        if(ss.length()<2) return true;
        int st=0;
        int e=ss.length()-1;
        while(st<e){
            if(ss.charAt(st++)!=ss.charAt(e--)){
                return false;
            }
        }
        return true;
    }
}