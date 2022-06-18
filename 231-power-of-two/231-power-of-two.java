class Solution {
    // public static boolean recur(int n){
        // if(n==0){
            // return false;
            
        // }
        // else if (n==1){
            // return true;
            
        // }
        // return recur(n/2);
    // }
    public boolean isPowerOfTwo(int n) {
        // return recur(n);
        // if(n&1==0){
        //     return false;
        // }
        // else{
        //     return true;
        // }
        // // return (n&1)
        int count=0;
        while(n!=0){
            int bit=(n&1);
            
            if (bit==1){
                n>>=1;
                count++;
                break;
            }
            n>>=1;
            
        }
        if((count==1 && n!=0)|| count==0){
            return false;
        }
        return true;
    }
}