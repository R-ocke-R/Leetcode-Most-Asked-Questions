class Solution {
    public boolean isPowerOfTwo(int n) {
//         int count=0;
//         for(int i=0;i<32;i++){
//             if((n&(1<<i))==(1<<i)){
//                 count++;
//                 if(count==2){
//                     return false;
//                 }
//             }
            
//         }
//         if((count==1 && n!=0) || count==0)return false;
//         return true;
        if(n<0) return false;
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        // System.out.println(count);
        if (count==1)
        return true;
        return false;
    }
}