class Solution {
    public String minWindow(String s, String t) {

        // to store min length and startIndex of string to be able to return the sequence.
        int startIndex = 0;
        int minLen = Integer.MAX_VALUE;

        // Lengths
        int n = s.length();
        int m = t.length();

        // Map to have a count of t's characters
        HashMap<Character, Integer> map = new HashMap<>();
        int count =0;
        
        // pointers
        int left = 0;
        int right = 0;

        for(int i = 0; i < m ; i++){
            char ch = t.charAt(i);
            int freq  =  map.getOrDefault(ch, 0);
            map.put(t.charAt(i), freq + 1 );
        }

        while(right < n){
            char ch = s.charAt(right ++);
            int freq = map.getOrDefault(ch, 0);
            
            // we got an element that was in t.
            if(freq > 0) count ++;
            map.put(ch, freq-1);

            // check if window is desirable
            while(count == m){
                // shrink window while updating the minimum.
                if(right - left + 1 < minLen){
                    // we have a new minLen
                    minLen = right - left +1;
                    startIndex = left;
                }
                char value = s.charAt(left ++);
                int valueFreq = map.get(value) + 1;
                // increase freq 
                map.put(value, valueFreq);
                // reduce count
                if(valueFreq == 1) count --;

            }     
            
        }
        if(minLen == Integer.MAX_VALUE ) return "";
        return s.substring(startIndex, startIndex+minLen-1);
    }
}