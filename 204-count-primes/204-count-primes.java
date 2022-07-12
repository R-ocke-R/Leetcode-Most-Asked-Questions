class Solution {
    public int countPrimes(int n) {
        //count the prime number from 2 to n exclusive 
        boolean[] isPrime= new boolean[n];
        // indexes of isPrime are from 0 to n-1; let's keep 
        // the same for the values itself.
        int count=0;
        
        for(int i=2;i<n;i++){
            if(!isPrime[i]){
                count++;
                for(int j=i;j<n;j+=i){
                    isPrime[j]=true;
                    // System.out.println(j+" a  "+i+"   " + count);
                    
                }
            }
            
        }
        // System.out.println(Arrays.toString(isPrime));
        return count;
        
        
    }
}