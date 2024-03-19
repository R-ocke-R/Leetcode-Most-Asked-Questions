class Solution {
    public int xorRange(int n){
        if( n % 4 == 0 ) return  n;
        else if ( n % 4 == 1 ) return 1;
        else if ( n % 4 == 2 ) return n+1;
        else return 0;
    }
    public int xorOperation(int n, int start) {
        // brute approach is where I do exactly what is written in the question. Using a for loop.
        // let's do the better appraoch which striver told us in our bit manipulation series
        // find a pattern first. 
        // an find a pattern-image in submission.
        // I will admit the pattern is almost impossible to find in an interview, because it hass to 
        // many cases unline lecture 8 in striver series, so its better to just solve/ understand that.
        // int last = start + 2 * (n-1);

        // if (start % 4 <= 1){
        //     if( n % 4 == 1) return last;
        //     else if (n%4 ==2 ) return 2;
        //     else if (n%2 == 3) return 2^last;
        //     else return 0;
        // }
        // else{
        //     if ( n%4 == 1) return start;
        //     else if(n%4 == 2) return start^last;
        //     else if(n%4 ==3 ) return start ^2;
        //     else return start^last^2;
            
        // }
        int res = start;
        for (int i=1; i<n; i++){
            res = res ^ (start + 2 * i);
            }
        return res;

    }
}
// its better to go with O(n) solution xD. there is no fucking obvious pattern.