class Solution {
    public boolean isPalindrome(int x) {
        // if(x<0) return false;
        // int reverse=0;
        // int copy=x;
        // while(copy!=0){
        //     reverse=(reverse*10)+(copy%10);   
        //     copy/=10;
        // }
        // if(x==reverse) return true;
        // return false;
        if(x<0|| x%10==0 && x!=0) return false;
        // to avoid integer overflow, we will only revert half of the number, somewhat like a two pointer approach
        int reverse=0;
        while(reverse<x){
            reverse=reverse*10 + x%10;
            x/=10;
        }
        if(x==reverse || reverse/10==x) return true;
        return false;
    }
}