class Solution {
    public int findComplement(int num) {
        // if(num==0){
        //     return 1;
        // }
        // int mask=0;
        // int m=num;
        // while(m!=0){
        //     mask=(mask <<1) | 1;
        //     m>>=1;
        // }
        // return mask&(~num);
        // int ans;.
        if(num==1)return 0;
        int set=31;
        for(int i=31;i>=1;i--){
            if((num & (1<<i))==1<<i){
                set=i;
                // System.out.println(i);
                break;
            }
        }
        for(int i=0;i<=set;i++){
            num=num^(1<<i);
            
        }return num;
    }
}