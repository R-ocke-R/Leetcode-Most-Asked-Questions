class Solution {
    public char findTheDifference(String s, String t) {
        int xor=0;
        int length=s.length();
        
        for(int i=0;i<length;i++){
            xor^=(int)t.charAt(i);
            xor^=(int)s.charAt(i);
        }
        xor^=(int)t.charAt(length);
        return (char)xor;
        
    }
}