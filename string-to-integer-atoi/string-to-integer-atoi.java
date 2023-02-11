class Solution {
    public int myAtoi(String s) {
        int index=0; int sign=1; int n=s.length(); int total=0;
        
        // empty?
        if(n==0) return 0;
        
        // remove whitespaces.
        while(index<n && s.charAt(index)==' ') index++;
        
        // if the input is only whitespaces
        if(index==n) return 0;
        
        // get the sign
        if(s.charAt(index)=='-' || s.charAt(index)=='+') {
            sign=s.charAt(index)=='-' ? -1 : +1;
            index++;
        }
        
        // convert to number
        
        while(index<n){
            int digit=s.charAt(index)-'0';
            if(digit<0 || digit>9) break;
            
            // overflow
            
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
        
            total=total * 10 + digit;
            index++;
        }
        return total * sign;
        
    }
}

//  public int myAtoi(String str) {
//         int sign = 1, base = 0, i = 0, INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
//         while (i < str.length() && str.charAt(i) == ' ') i++;
        
//         if (i >= str.length()) return 0;
        
//         if (str.charAt(i) == '+' || str.charAt(i) == '-') {
//             if (str.charAt(i) == '-') sign = -1;
//             i++;
//         }
        
//         while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
//             if (base > INT_MAX / 10 || (base == INT_MAX / 10 && str.charAt(i) - '0' > 7)) {
//                 if (sign == -1) return INT_MIN;
//                 else            return INT_MAX;    
//             }
//             base = 10 * base + (str.charAt(i++) - '0');
//         }
        
//         return base * sign;
        
//     }