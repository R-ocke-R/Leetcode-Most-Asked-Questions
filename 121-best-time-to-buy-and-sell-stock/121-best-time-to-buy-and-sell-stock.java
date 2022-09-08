class Solution {
    public int maxProfit(int[] prices, int dummy) {
        // int[] dp=new int[prices.length];
        int n=prices.length;
        
        int[] min=new int[n];
        min[0]=prices[0];
        for(int i=1;i<n;i++){
            min[i]=Math.min(prices[i], min[i-1]);
        }
        // System.out.println(Arrays.toString(min));
        
        int[] max=new int[n];
        max[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            max[i]=Math.max(prices[i], max[i+1]);
        }
        
        // System.out.println(Arrays.toString(min));
        int profit=-1;
        for(int i=0;i<n;i++){
            profit=Math.max(profit, max[i]-min[i]);
        }
        return profit;
        
    }

    public int maxProfit(int[] prices){
        //improving the space complexity of the approach
        int buy=prices[0];
        int mx=0;
        for(int i=1;i<prices.length;i++){
            int pr=prices[i];
            if(buy>pr) buy=pr;
            mx=Math.max(mx, pr-buy);

        }
        // System.out.println(buy+" "+ mx);
        return mx;
    }
}

//Notes:
/*
for any given element index, the profit depends on the index+1 to n; whereever we get 
more value than element at index itself.

dp approach ?

*/