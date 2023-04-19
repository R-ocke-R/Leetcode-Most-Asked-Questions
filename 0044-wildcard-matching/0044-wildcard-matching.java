class Solution {
    public boolean recursive(String s, String pattern, int i, int j){
        //  base case
        // both string and pattern over
        if(i==-1 && j==-1){
            return true;
        }
        // if pattern over but string not over.
        if(i>=0 && j<0)
            return false;
        // if string over but pattern not over
        else if(j>=0 && i<0){
            // one may have more pattern characters remaining
            // other of the two choices, is the remaining pattern can have all stars too
            // which can still make up the string.
            for(int k=0; k<=j;k++){
                if(pattern.charAt(k) != '*') return false;
            }
            return true;
        }
        
        // function working
        if(s.charAt(i)==pattern.charAt(j) || pattern.charAt(j)=='?'){
            return recursive(s, pattern, i-1, j-1);
        }
        else if (pattern.charAt(j)=='*'){
            return (recursive(s, pattern, i-1, j) || recursive(s, pattern, i, j-1));
        }
        return false;        
    }
    public int memo(String s, String pattern, int i, int j, int[][] dp){
        if(i==-1 && j==-1){
            return 1;
        }
        if(i>=0 && j<0)
            return -1;
        else if(j>=0 && i<0){
            for(int k=0; k<=j;k++){
                if(pattern.charAt(k) != '*') return -1;
            }
            return 1;
        }
        // memo returning.
        if(dp[i][j]!=0) {
            if(dp[i][j]==-1) return -1;
            else return 1;
        }
        int val = -1;
        if(s.charAt(i)==pattern.charAt(j) || pattern.charAt(j)=='?'){
            val = memo(s, pattern, i-1, j-1, dp);
        }
        else if (pattern.charAt(j)=='*'){
            val = memo(s, pattern, i-1, j, dp);
            
            if(val!=1){
                val = memo(s, pattern, i, j-1, dp);
            }
        }
        else val = -1;
        
        if (val==1) dp[i][j] = 1;
        else dp[i][j] = -1;
        
        return dp[i][j];
 
    }
    public boolean isMatch(String s, String p) {
        // return recursive(s, p, s.length()-1, p.length()-1);
        // recursive TLE
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        //0 is not computed.
        //1 for computed true;
        //-1 for computed false;
        int val = memo(s, p, s.length()-1, p.length()-1, dp);
        if (val==1) return true;
        return false;
    }
}



/*
cases:

if *  then replace with * and whatever character that was needed to be matchd

if ? then you must replace with whats needed.




match:
str(i)==str(j)

or

question mark is also a match

both I-1, j-1;
*/