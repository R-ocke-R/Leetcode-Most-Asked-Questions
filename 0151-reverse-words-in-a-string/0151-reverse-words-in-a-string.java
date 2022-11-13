class Solution {
//     public String reversal(String s){
//         // base case
//         s=s.trim();
//         if(s.length()==0){
//             return "";
//         }            
//         // make one work and call recursive function
//         // String word="";
//         s=s.trim();
//         int index=0;
//         while(index<s.length() && s.charAt(index)!=' ') index++;

//         if(index==s.length()-1) return s;
        
//         String word=" "+s.substring(0, index); //System.out.println(word);
        
//         return reversal(s.substring(index+1))+word;
//     }
    public String reverseWords(String s) {
        
        String reverseSentence="";
        String word="";
        s=s+" ";
        
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)!=' ' && s.charAt(i+1)==' '){
                // word has completed
                // so add word to reverseSentence
                word+=s.charAt(i);
                word+=" ";
                reverseSentence=word+reverseSentence;
                word="";               
                
                
            }
            else if(s.charAt(i)!=' '){
                // add char to word
                word+=s.charAt(i);
            }
        }
        return reverseSentence.trim();
    }
}
