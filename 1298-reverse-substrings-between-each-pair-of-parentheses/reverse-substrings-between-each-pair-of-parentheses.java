class Solution {
    public String reverseParenthesesBrute(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(char currentChar : s.toCharArray()){
            if(currentChar == '('){
                stack.push(result.length());
            }
            else if(currentChar == ')'){
                int start = stack.pop();
                reverse(result, start, result.length()-1);
            }
            else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
    public void reverse(StringBuilder sb, int start, int end){
        while(start < end){
            char ch = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, ch);
        }
    }
    public String reverseParentheses(String s){
        // create  a mapping of parenthsis
        int n = s.length();
        Stack <Integer> stack = new Stack<>();
        int[] pair = new int[n];


        for(int i = 0; i< n; i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            if(s.charAt(i)==')'){
                int j = stack.pop();
                pair[i]=j;
                pair[j]=i;
            }       
        }

        StringBuilder result = new StringBuilder();
        for(int index = 0, direction = 1; index < n; index += direction){
            if(s.charAt(index) == '(' || s.charAt(index) == ')'){
                index = pair[index];
                direction = -direction;
            }
            else result.append(s.charAt(index));
        }
        return result.toString();

    }
}