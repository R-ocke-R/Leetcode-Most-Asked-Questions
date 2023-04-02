class Solution {
    public int dayIncrement(int[] days, int currIndex, boolean value){
        if (value){
            // increment current index with factor 7
            int currValue=days[currIndex];
            int nextValue=currValue+7;
            
            while(currValue<nextValue){
                currIndex++;
                if(currIndex==days.length) break;
                currValue=days[currIndex];
            }
            return currIndex;
        }
        else {
            int currValue=days[currIndex];
            int nextValue=currValue+30;
            
            while(currValue<nextValue){
                currIndex++;
                if(currIndex==days.length) break;
                currValue=days[currIndex];
            }
            return currIndex;
        }
    }
    
    public int function(int[] days, int[] costs, int index){
        
        // base case
        // index<0 or index>=days.length
        if (index==days.length) return 0;
                
        
        // function work
        int dollar=Integer.MAX_VALUE;
        // one day
        dollar=Math.min(dollar, costs[0] + function(days, costs, index+1));
        
        // seven days
        dollar=Math.min(dollar, costs[1] + function(days, costs, dayIncrement(days, index, true)));
        
        // month ticket
        dollar=Math.min(dollar, costs[2] + function(days, costs, dayIncrement(days, index, false)));
        
        return dollar;
    }
    
    public int mincostTickets(int[] days, int[] costs) {
        // recursive function call: its working nicely
        //return function(days, costs, 0);
        
        //memoization
        // int[] dp=new int[days.length];
        // return memo(days, costs, 0, dp);
        // worked but gave TLE on some testcase on submission.
        
        //tabulation
        return tab(days, costs);
        
    }
    
    public int tab(int[] days, int[] costs){
        int n=days.length;
        int[] dp = new int[n+1];
        dp[n]=0;
        
        for(int index = n-1; index >= 0 ; index--){
            int dollar=Integer.MAX_VALUE;
            dollar=Math.min(dollar, costs[0] + dp[index+1]);
        
            // seven days
            dollar=Math.min(dollar, costs[1] + dp[dayIncrement(days, index, true)]);

            // month ticket
            dollar=Math.min(dollar, costs[2] + dp[dayIncrement(days, index, false)]);
//             int nextIndex=index+1;            
//             if(nextIndex < n) dollar=Math.min(dollar, costs[0] + dp[nextIndex]);
//             else dollar=Math.min(dollar, costs[0]);

//             // seven days
//             nextIndex=dayIncrement(days, index, true);
//             if(nextIndex < n) dollar=Math.min(dollar, costs[1] + dp[nextIndex]);
//             else dollar=Math.min(dollar, costs[1]);
            
//             // month ticket
//             nextIndex=dayIncrement(days, index, false);
//             if(nextIndex < n) dollar=Math.min(dollar, costs[2] + dp[nextIndex]);
//             else dollar=Math.min(dollar, costs[1]);
            
            
            dp[index]=dollar;
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
    
    
    
    public int memo(int[] days, int[] costs, int index, int[] dp){
        
        if(index==-1 || index==days.length) return 0;
        
        //memo
        if(dp[index]!=0) return dp[index];
        
        // function work
        int dollar=Integer.MAX_VALUE;
        // one day
        dollar=Math.min(dollar, costs[0] + function(days, costs, index+1));
        
        // seven days
        dollar=Math.min(dollar, costs[1] + function(days, costs, dayIncrement(days, index, true)));
        
        // month ticket
        dollar=Math.min(dollar, costs[2] + function(days, costs, dayIncrement(days, index, false)));
        
        dp[index]=dollar;
        return dollar;
    }
}