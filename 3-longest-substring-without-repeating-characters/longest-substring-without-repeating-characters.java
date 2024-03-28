class Solution {
    public int lengthOfLongestSubstringBetter(String s) {
        int n = s.length();
        int maxL = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        int l = 0;
        int r = 0;
        while(r < n ){
            char ch = s.charAt(r);
            // if contains then shrink left pointer
            if(charMap.containsKey(ch)){
                if(charMap.get(ch) >= l){
                    l = charMap.get(ch) + 1;
                }
            }
            maxL = Math.max(r-l+1, maxL);
            charMap.put(ch, r++);
        }
        return maxL;
    }
    public int lengthOfLongestSubstring(String s) {
        // improving the space complexity from O(n) to O(1)
        int n = s.length();
        int maxL = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);

        int l = 0;
        int r = 0;
        while(r < n ){
            char ch = s.charAt(r);
            // if contains then shrink left pointer
            if(charIndex[ch] != -1){
                if(charIndex[ch] >= l){
                    l = charIndex[ch] + 1;
                }
            }
            maxL = Math.max(r-l+1, maxL);
            charIndex[ch] = r++;
        }
        return maxL;
    }
}