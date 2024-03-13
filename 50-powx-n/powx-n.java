class Solution {
    public double myPow(double x, int n) {
        return optimised(x, (long) n);
    }
    public double brute(double x, int n){
        if(n==0) return 1;
        if (n<0) return 1/brute(x, -n);
        else return (x * brute(x, n-1));
    }
    public double optimised(double x, long n){
        if(n==0) return 1;
        if(n<0) {
            n =-1*n;
            x=1.0/x;
        }
        double result = 1;
        while(n>0){
            if(n%2==1){
                result *=x;
                n-=1;
            }
            x=x*x;
            n = n/2;
        }
        return result;
    }
}

/** 
This question asks us to calculate x to the power of n which can be done via brute force, in n steps
both of the approaches can be done iteratively or recursively

1. Brute:
solved the question as it comes. TC : O(n) where the constraints of n are pretty large for the question

2. Optimized:
this approach asks for a technique called fast expotentiation or binary exponentiation.
instead of doing x*x*x*x*x*x n times.

with do this:
2*2=4
4*4=16 which is 2*2*2*2
16*16 will give 2^8.

this is basic technique that anyone can intuitively think off.
so let's code it. (iteratively)
 */