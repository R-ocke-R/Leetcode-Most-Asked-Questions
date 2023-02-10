class Solution {
    public boolean isAnagram(String s, String t) {
        int[] array1=new int[26];
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            array1[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            if(array1[t.charAt(i)-'a']!=0) array1[t.charAt(i)-'a']--;
            else return false;
        }
        return true;
    }
}