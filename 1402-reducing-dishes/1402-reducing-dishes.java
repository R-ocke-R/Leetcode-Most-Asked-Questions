

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
    
    public int maxSatisfaction(int[] satisfaction) {
        
        // calling recursive
        // Arrays.sort(satisfaction);
        // return recursive(satisfaction, 1, 0);
        
        // Recursive gives TLE> Moving to MEMO> 
        
        Arrays.sort(satisfaction);
        int[][] dp= new int[satisfaction.length+1][satisfaction.length+1];
        return memo(satisfaction, 1, 0, dp);
        
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