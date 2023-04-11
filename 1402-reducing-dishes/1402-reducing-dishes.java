

class Solution {
    
    public int recursive(int[] satisfaction, int time, int index){
        // base
        
        if(index==satisfaction.length) return 0;
        
        // function calling
        
        // include
        
        int num = time * satisfaction[index] + recursive(satisfaction, time+1, index+1);
        
        // exclude
        
        num = Math.max(num, recursive(satisfaction, time, index+1));
        
        return num;
    }
    
    public int memo(int[] satisfaction, int time, int index, int[][] dp){
        // base
        
        if(index==satisfaction.length) return 0;
        if(dp[time][index]!=0) return dp[time][index];
        
        // function calling
        
        // include
        
        int num = time * satisfaction[index] + memo(satisfaction, time+1, index+1, dp);
        
        // exclude
        
        num = Math.max(num, memo(satisfaction, time, index+1, dp));
        
        dp[time][index]=num;
        return dp[time][index];
    }
    
    public int tabulation(int[] satisfaction){
        // dont' stress over this, very concrete steps.
        
        // first, create the DP array, the fill in the base cases
        int n= satisfaction.length;
        int[][] dp= new int[n+1][n+1];
        // base is 0 at n index, which is already filled
        
        // second, reverse the flow from top down to bottom up.
        
        for(int index=n-1; index>=0; index--){
            for(int time=index; time>=0; time--){
                // third is to copy the recursive steps and change calls to DP.
        
                int num = ((time+1) * satisfaction[index]) + dp[time+1][index+1];

                num = Math.max(num, dp[time][index+1]);

                dp[time][index]=num;
            }
        }
        return dp[0][0];

    }
    public int maxSatisfaction(int[] satisfaction) {
        
        // calling recursive
        // Arrays.sort(satisfaction);
        // return recursive(satisfaction, 1, 0);
        
        // Recursive gives TLE> Moving to MEMO> 
        
        // Arrays.sort(satisfaction);
        // int[][] dp= new int[satisfaction.length+1][satisfaction.length+1];
        // return memo(satisfaction, 1, 0, dp);
        
        // Passed with memo here, how hard was this.
        Arrays.sort(satisfaction);
        return tabulation(satisfaction);
        
    }
}

/* Intuition from Love

1. we need maximum like time coefficient, doesn't that mean I take all the 
positive satisfactions and discard the rest...

-> maybe, maybe not, we must first understand that the largest satisfaction will be multiplied by the maximum time when nothing is discarded.

2. So one major understanding would also be to sort the satisfaction array to 
take the greater satisfactions to the end.

3. once you visualise that its really intuitive to draw the question down to 
include-exclude problem.

*/