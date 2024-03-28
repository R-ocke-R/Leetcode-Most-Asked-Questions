class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        
        // these store the last occurance of their individual characters
        int a = -1;
        int b = -1;
        int c = -1;

        // counter
        int count = 0;

        for(int i = 0; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == 'a') a = i;
            else if (ch == 'b') b = i;
            else c = i;

            if(a != -1 && b != -1 && c != -1){
                count += 1 + Math.min(a, Math.min(b, c));
            }
        }
        return count;
    }
}