class Solution {
    
    public boolean isPerfectSquare(int num) {
        
        if(num==1) return true;
        
        long min = 0;
        long max = num;
        
        while(min <= max){
            long mid= min + (max-min)/2;
            long square = mid*mid;
            
            if(square==num) return true;
            
            if(square<num) min=mid+1;
            else max=mid-1;
        }
        return false;
    }
}