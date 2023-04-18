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
    public int tabulation(String word1, String word2){
        int n=word1.length();
        int m= word2.length();
        int[][] dp = new int[n+1][m+1];
        
        // filling the base cases
        for(int i=0; i<m; i++){
            dp[n][i]=m-i;
        }
        for(int j=0;j<n;j++){
            dp[j][m]=n-j;
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int ans = 0;
                if(word1.charAt(i)==word2.charAt(j)) ans = dp[i+1][j+1];
        
                else {
                    ans = 1 + dp[i][j+1];
                    ans = Math.min(ans, 1 + dp[i+1][j]);
                    ans = Math.min(ans, 1 + dp[i+1][j+1]);
                }
                dp[i][j]=ans; 
            }
        }
        return dp[0][0];
        
        
    }
    public int minDistance(String word1, String word2) {
        // return recursive(word1, word2, 0, 0)
        // recursive TLE
        
        //memo
        // int[][] dp = new int[word1.length()][word2.length()];
        // return memo(word1, word2, 0, 0, dp);
        
        //tabulation
        return tabulation(word1, word2);
    }
}