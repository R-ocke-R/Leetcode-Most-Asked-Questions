class Solution {
    public int countPrimes(int n){
        boolean[] isPrime= new boolean[n];
        int count=0;
        for(int i=2;i<n;i++){
            if(!isPrime[i]){
                count++;
                for(int j=i;j<n;j+=i){
                    isPrime[j]= true;
                }
            }
        }
        return count;
    } 
}