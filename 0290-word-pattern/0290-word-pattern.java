class Solution {
    public boolean wordPattern(String pattern, String s) {
        //brute approach intuition is hashmap

        
        HashMap<Character, String> map= new HashMap<>();
        String[] words = s.split(" ");
        
        
        if(pattern.length() != words.length) return false;
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            if(map.containsValue(words[i]) && !map.containsKey(ch)) return false;
            if(map.containsKey(ch)){
                //it contains then it should be the same word  as the value in string s
                // System.out.println(ch+""+map.get(ch)+""+ words[i]);
                if(!map.get(ch).equals(words[i])) return false;
            }
            else{
                map.put(ch, words[i]);
            }
        }
        return true;
    }
    
}