class Solution {
    public int sum(int n){
        // sum of first n natural numbers formulae:
        int sum = (n * (n+1)) /2;
        return sum;
    }
    public int pivotInteger(int n) {
        // Implementing a BS algo which searches for the value of x which satisfies the conditions.
        int start = 1;
        int end = n;
        int sumt = sum(n);
        while(start<=end){
            int mid = (start + end )/2;
            int sum1 = sum(mid);
            int sum2 = sumt-sum1+mid;

            if(sum2 == sum1) return mid;
            else if(sum2>sum1) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}