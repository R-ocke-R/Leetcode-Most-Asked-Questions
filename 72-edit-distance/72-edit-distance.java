class Solution {
    public int minDistance(String word1, String word2) {
        char[] one=word1.toCharArray();
        char[] two=word2.toCharArray();
        
        int n=word1.length();
        int m=word2.length();
        
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=i;
        }
        for(int j=0;j<dp.length;j++){
            dp[j][0]=j;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(one[i-1]==two[j-1])
                    dp[i][j]=dp[i-1][j-1];
                
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
}



//edit distance means number of operations of editing.

// again the tool we are going to use is a 2D matrix.
// to compare both the string provided.