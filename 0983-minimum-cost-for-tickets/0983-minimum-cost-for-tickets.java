class pair{
        int day;
        int cost;
        public pair(int day, int cost){
            this.day=day;
            this.cost=cost;
        }
    }
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
    
    public int tab(int[] days, int[] costs){
        int n=days.length;
        int[] dp = new int[n+1];
        dp[n]=0;
        
        for(int index = n-1; index >= 0 ; index--){
            int dollar=Integer.MAX_VALUE;
            dollar=Math.min(dollar, costs[0] + dp[index+1]);
        
            dollar=Math.min(dollar, costs[1] + dp[dayIncrement(days, index, true)]);

            dollar=Math.min(dollar, costs[2] + dp[dayIncrement(days, index, false)]);
            
            dp[index]=dollar;
        }
        return dp[0];
    }
    
    public int mincostTickets(int[] days, int[] costs) {
        // recursive function call: its working nicely
        //return function(days, costs, 0);
        
        //memoization
        // int[] dp=new int[days.length];
        // return memo(days, costs, 0, dp);
        // worked but gave TLE on some testcase on submission.
        
        //tabulation
        // return tab(days, costs);
        // worked nicely and easy
        
        // space Optimization
        
        return space(days, costs);
        
    }
    
    public int space(int[] days, int[] costs){
        Queue<pair> week = new LinkedList<>();
        Queue<pair> month = new LinkedList<>();
        
        int ans=0;
        
        for(int day : days){
            // step 1: remove expired days
            while(!week.isEmpty() && week.peek().day + 7 <=day) week.remove();        
            while(!month.isEmpty() && month.peek().day + 30 <=day) month.remove();    
            
            // step 2: add cost for today in queue
            week.add(new pair(day, ans+costs[1]));
            month.add(new pair(day, ans+costs[2]));
            
            // update ans
            ans = Math.min(ans+costs[0], Math.min(week.peek().cost, month.peek().cost));
        }
        
        
        return ans;
    }
}