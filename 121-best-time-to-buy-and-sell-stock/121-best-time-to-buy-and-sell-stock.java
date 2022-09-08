class Solution {
    public int maxProfit(int[] prices) {
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
}

//Notes:
/*
for any given element index, the profit depends on the index+1 to n; whereever we get 
more value than element at index itself.

*/