public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // System.out.println(n);
        
//         Approach1 
        // convert number to binary, now check for each digit to be one or zero.
            
//         Approach2 
        // right shift the number until n!=0
        int siu=0;
        
        // while (n!=0){
//         for(int i=0;i<32;i++){
// //             checking the last digit is one or zero
//             if((n&1)==1)
//                 siu++;
            
//             n>>=1;
//             if (n==0){
//                 break;
//             }
//         }
//         Approach3
    	while(n!=0) {
    		siu = siu + (n & 1);
    		n = n>>>1;
    	}

    
        return siu;
    }
}