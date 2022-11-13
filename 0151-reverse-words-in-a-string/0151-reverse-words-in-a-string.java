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
    
    // first approach
    
//     public String reverseWords(String s) {
//         // char[] arr=s.toCharArray();
//         String reverseSentence="";
//         String word="";
//         s=s+" ";
        
//         for(int i=0;i<s.length()-1;i++){
//             if(s.charAt(i)!=' ' && s.charAt(i+1)==' '){
//                 // word has completed
//                 // so add word to reverseSentence
//                 word+=s.charAt(i);
//                 if(reverseSentence.length()!=0) word+=" ";
//                 reverseSentence=word+reverseSentence;
//                 word="";               
                
                
//             }
//             else if(s.charAt(i)!=' '){
//                 // add char to word
//                 word+=s.charAt(i);
//             }
//         }
//         return reverseSentence;
//     }
    public String reverseWords(String s){
        //Stack Approach + String builder to reduce space to O(1) and O(n) stack.
    
        Stack<String> st = new Stack<String>();
        for (String a : s.trim().split(" ")) {
            if (!a.isEmpty())
                st.push(a);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
            sb.append(" ");            
        }
        return sb.toString().trim();
    }
}
