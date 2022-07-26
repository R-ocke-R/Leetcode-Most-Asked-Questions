class Solution {
    public String toStr(Stack<Character> stack){
        StringBuilder st=new StringBuilder();
        int ss=stack.size();
        for(int i=0;i<ss;i++){st.append(stack.pop());}
        st.reverse();
        return st.toString();
        
    }
    public String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        int i=0;
        while(i<s.length()){
            //check if stack is non empty then peek element, if its equal to charAt(i) pop it and i++; else push.
            if(stack.size()!=0 && stack.peek()==s.charAt(i)){
                stack.pop();i++;
                continue;                
            }
            stack.push(s.charAt(i));
            i++;
        }
        
        return toStr(stack);
    }
}