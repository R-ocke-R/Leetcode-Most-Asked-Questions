class Solution {
    public int mySqrt(int x) {
        //approach    O(root(N))  comparing squares of integers to x
        long ans=-1;
        int s=0;
        int e=x;
        long mid=s+(e-s)/2;
        while(s<=e){
            long square=mid*mid;
            if(square==x){
                return (int) mid;
                
            }
            else if(square>x){
                e=(int)mid-1;
            }
            else{
                ans=mid;
                s=(int)mid+1;
            }
            mid=s+(e-s)/2;
        }
        return (int)ans;
    }
}