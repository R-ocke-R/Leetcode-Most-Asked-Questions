class Solution {
    public boolean isPalindrome(String s) {
        
    
        String ss=new String();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                ss+=Character.toLowerCase(s.charAt(i));
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