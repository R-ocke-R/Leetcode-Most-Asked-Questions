class Solution {
    public int numSquares(int n) {
        return tab(n);
    }
    public int recursive(int n){
        // base case
        if(n==0) return 0;
        
        int ans = n;
        for(int i=2; i*i <= n; i++){
            
            ans = Math.min(ans, 1+recursive(n-i*i));
        }
        
        return ans;
    }

    public void memo(int n){
        return;
    }
    public int tab(int n){
        int[] dp= new int[n+1];
        
        dp[0]=0;
        for(int i=1; i<=n; i++){
            dp[i] = i;
            for(int j=2; j*j <= n; j++){
                if(i-j*j>=0) dp[i] = Math.min(dp[i], 1+dp[i-j*j]);
            }
        }
        return dp[n];
    } 
}