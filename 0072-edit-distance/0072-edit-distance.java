class Solution {
    public int recursive(String word1, String word2, int i, int j){
        // base case
        
        if(i==word1.length()){
            return word2.length()-j;
        }
        if(j==word2.length()){
            return word1.length()-i;
        }
        
        // function working
        
        if(word1.charAt(i)==word2.charAt(j)) return recursive(word1, word2, i+1, j+1);
        
        
        //else case
        // insert
        int ans = 1 + recursive(word1, word2, i, j+1);
        // delete
        ans = Math.min(ans, 1 + recursive(word1, word2, i+1, j));
        // update
        ans = Math.min(ans, 1 + recursive(word1, word2, i+1, j+1));
        
        return ans;
    }
    public int memo(String word1, String word2, int i, int j, int[][] dp){
        if(i==word1.length()){
            return word2.length()-j;
        }
        if(j==word2.length()){
            return word1.length()-i;
        }
        if(dp[i][j]!=0) return dp[i][j];
        
        if(word1.charAt(i)==word2.charAt(j)) return memo(word1, word2, i+1, j+1, dp);
        
        int ans = 1 + memo(word1, word2, i, j+1, dp);
        ans = Math.min(ans, 1 + memo(word1, word2, i+1, j, dp));
        ans = Math.min(ans, 1 + memo(word1, word2, i+1, j+1, dp));
        
        dp[i][j]=ans;
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        // return recursive(word1, word2, 0, 0)
        // recursive TLE
        
        //memo
        int[][] dp = new int[word1.length()][word2.length()];
        return memo(word1, word2, 0, 0, dp);
    }
}