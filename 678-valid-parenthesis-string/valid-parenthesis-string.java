class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int minR = 0;
        int maxR = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i)=='('){
                minR ++;
                maxR ++;
            }
            else if(s.charAt(i)==')'){
                minR--;
                maxR--;
            }
            else{
                // ** case of ** 
                minR--;
                maxR++;
            }
            if(minR < 0) minR =0;
            if(maxR < 0 ) return false;
        }
        return minR == 0 ? true : false;

    }
}