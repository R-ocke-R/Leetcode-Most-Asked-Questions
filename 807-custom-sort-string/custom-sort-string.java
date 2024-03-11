class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> freq = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i),0)+1);                    
        }

        for(int i=0;i<order.length();i++){
            char letter = order.charAt(i);
            int free = freq.getOrDefault(letter, 0);
            for (int j=0;j<free;j++){
                sb.append(letter);
            }
            freq.put(letter, 0);
            
        }
        for(char letter : freq.keySet()){
            int count = freq.get(letter);
            while(count > 0){
                sb.append(letter);
                count --;
            }
        }
        return sb.toString();

    }
}

/**
1. use comparator based sorting
2. this approach above.
 */