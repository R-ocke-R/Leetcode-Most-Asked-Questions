class Solution {
    public boolean allUpper(String word){
        for(int i=1;i<word.length()-1;i++){
            if(Character.isLowerCase(word.charAt(i))) return false;
        }
        return true;
    }
    public boolean allLower(String word){
        for(int i=1;i<word.length()-1;i++){
            if(Character.isUpperCase(word.charAt(i))) return false;
        }
        return true;
    }
    public boolean detectCapitalUse(String word) {
        boolean ch1=Character.isUpperCase(word.charAt(0));
        boolean ch2=Character.isUpperCase(word.charAt(word.length()-1));
        
    
        if(ch1 && ch2){
            //either all are upper case // or false
            if(allUpper(word)==true) return true;
            else return false;
        }
        else if(ch2 && !ch1) return false;
        
        else if(allLower(word)==true) return true;
        return false;

    }
}