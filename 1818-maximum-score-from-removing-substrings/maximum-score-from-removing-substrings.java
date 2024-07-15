class Solution {
    public int maximumGain(String s, int x, int y) {
        // implementing the greedy approach using 2 passes
        // we will be using a stack as well.
        int score = 0;
        if(x > y){
            int initialLen = s.length();
            s = removal(s, "ab");
            int lenAfterPass = s.length();
            score += (initialLen - lenAfterPass)/2 * x;

            s = removal(s, "ba");
            score += (lenAfterPass - s.length())/2 * y;
        }
        else{
            int initialLen = s.length();
            s = removal(s, "ba");
            int lenAfterPass = s.length();
            score += (initialLen - lenAfterPass)/2 * y;

            s = removal(s, "ab");
            score += (lenAfterPass - s.length())/2 * x;
        }
        return score;
    }
    public String removal(String s, String pair){
        // this function will return a count indicating the number of pairs removed
        // this function will return the string itself.. then I'll calulate the removed number 
        // of pairs using the difference in length -> this is better.
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char charac = s.charAt(i);
            if(charac== pair.charAt(1) && !stack.isEmpty() && stack.peek() == pair.charAt(0)){
                stack.pop();
            }
            else stack.push(charac);
        }
        StringBuilder rem = new StringBuilder();
        while(!stack.isEmpty()){
            rem.append(stack.pop());
        }
        return rem.reverse().toString();
    }

}