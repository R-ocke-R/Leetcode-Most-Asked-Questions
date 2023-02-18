class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map= new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(map.containsValue(ch)) stack.push(ch);
            else {
                if(stack.isEmpty()) return false;
                if(map.get(ch)!=stack.pop()) return false;
            }
        }
                
        if(!stack.isEmpty()) return false;
        return true;
    }
}