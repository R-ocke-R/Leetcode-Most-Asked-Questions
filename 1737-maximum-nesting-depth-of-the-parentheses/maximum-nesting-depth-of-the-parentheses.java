class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int n = s.length();
        int maxC =0;

        for(int i = 0; i < n; i++){
            maxC = Math.max(maxC, count);
            if(s.charAt(i)=='(') count ++;
            else if(s.charAt(i)==')') count --;
        }
        return maxC;
    }
}