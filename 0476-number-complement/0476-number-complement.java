class Solution {
    public int findComplement(int num) {
        int mask=0;
        int set=0;
        for(int i=31;i>=0 && ((num & 1<<i)!=(1<<i));i--){
                set=i;
        }

        //creating the mask
        while(set--!=0){
            mask=((mask<<1) | 1);
        }

        
        return (~num)&mask;
    }
}