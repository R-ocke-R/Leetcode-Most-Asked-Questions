class Solution {
    // public int hammingDistance(int x, int y) {
    //     // int count=0;
    //     // while(x!=0 && y!=0){
    //     //     if(((x&1)^(y&1))==1){
    //     //         count++;
    //     //     }
    //     //     x>>=1;
    //     //     y>>=1;
    //     // }
    //     // return count;
    // }
    
    public int hammingDistance(int x , int y){
        int count=0;
        int xor=x^y;
        
        int mask=1;
        for(int i=0;i<32;i++){
            if((xor&mask)!=0){
                count++;
            }
            mask<<=1;
        }
        return count;
    }
}

// Approach : XOR the lsb each time 