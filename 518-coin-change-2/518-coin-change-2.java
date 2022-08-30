class Solution {
    public int change(int amount, int[] coins) {
        int[] comb=new int[amount+1];
        
        //initialisation
        comb[0]=1;
        
        for(int i =0;i<coins.length;i++){
            int coin=coins[i];
            for(int j=coin;j<amount+1;j++){
                comb[j]+=comb[j-coin];
                
            }
        }
        return comb[amount];   
    }
}