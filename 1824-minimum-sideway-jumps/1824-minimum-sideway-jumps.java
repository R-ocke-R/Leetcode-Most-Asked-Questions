class Solution {
    public int recursive(int[] obstacles, int index, int lane){
        // base case
        if(index+1==obstacles.length) return 0;
        // function calling
        int ans = Integer.MAX_VALUE;
        // either the obstacle not in the lane
        // though i can still move.
        if( obstacles[index+1]==0 || obstacles[index+1]!=lane) ans = Math.min(ans, recursive(obstacles, index+1, lane)); 
        
        // or three is an obstacle in this lane
        else {
           for(int newLane = 1; newLane <=3 ; newLane++){
               if(newLane!=lane && obstacles[index]!=newLane){
                   ans = Math.min(ans, 1+ recursive(obstacles, index+1, newLane));
               }
           }
            
        }
        return ans;
        
    }
    
    public int memo(int[] obstacles, int index, int lane, int[][] dp){
        
        if(index+1==obstacles.length) return 0;
        
        //base case for memoization
        if(dp[lane][index] != 0) return dp[lane][index];
        
        // function calling
        int ans = Integer.MAX_VALUE;
        // either the obstacle not in the lane
        // though i can still move.
        if( obstacles[index+1]==0 || obstacles[index+1]!=lane) ans = Math.min(ans, recursive(obstacles, index+1, lane)); 
        
        // or three is an obstacle in this lane
        else {
           for(int newLane = 1; newLane <=3 ; newLane++){
               if(newLane!=lane && obstacles[index]!=newLane){
                   ans = Math.min(ans, 1+ recursive(obstacles, index, newLane));
               }
           }  
        }
        dp[lane][index]=ans;
        return ans;
    }
    
    public int tabulation(int[] obstacles){
        int n=obstacles.length-1;
        int[][] dp = new int[4][n+1];
        
        dp[0][n] = 0;
        dp[1][n] = 0;
        dp[2][n] = 0;
        dp[3][n] = 0;
        
        for(int index=n-1; index>=0; index--){
            for(int lane=1; lane<=3; lane++){
                int ans = Integer.MAX_VALUE;
                if( obstacles[index+1]==0 || obstacles[index+1]!=lane) ans = dp[lane][index+1]; 

                // or three is an obstacle in this lane
                else {
                    for(int newLane = 1; newLane <=3 ; newLane++){
                        if(newLane!=lane && obstacles[index]!=newLane){
                            ans = Math.min(ans, 1+ dp[newLane][index+1]);
                        }
                    }
                }
                dp[lane][index]=ans;
            }
        }
        // System.out.println(Arrays.toString(dp[1]));
        // System.out.println(Arrays.toString(dp[2]));
        // System.out.println(Arrays.toString(dp[3]));
        return Math.min(dp[2][0], 1 + Math.min(dp[1][0], dp[3][0]));        
    }
    
    public int minSideJumps(int[] obstacles) {
        // recursive call
        // return recursive(obstacles, 0, 2);
        
        // Memo
        // 3 rows for the three different lanes, and one for useless 0th lane, so that we won't mess with the indexes, its actually of no use. 
        // int[][] dp= new int[4][obstacles.length];
        // int ans =memo(obstacles, 0, 2, dp);
        // return ans;
        
        // tabulation
        return tabulation(obstacles);
    }
}