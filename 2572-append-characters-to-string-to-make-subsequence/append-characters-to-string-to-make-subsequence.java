class Solution {
    public int appendCharacters(String s, String t) {
        int maxApp = 0;
        int sn = s.length();
        int tn = t.length();
        int i = 0;
        int j = 0;

        while(i<tn && j<sn){
            char find = t.charAt(i);
            char show = s.charAt(j);
            if(find == show) {
                i++; j++;
            }
            else j++;
        }
        maxApp = tn-i;
        return maxApp;
    }
}

// maximum conseq patternj.
// O(n^2) brute?
// nah

// need all elements of t in s and subseuence he toh we need to take care of the order as well.