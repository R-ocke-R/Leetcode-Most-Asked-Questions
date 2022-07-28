class Solution {
    public int fib(int n) {

        if(n==1) return 1;

        int a=0;
        int b=1;
        int c=0;

        for (int i = 2; i <= n; i++) {
            c=a+b;
            //now c is the new value
            a=b;
            b=c;
        }    
        return c;
    }
}