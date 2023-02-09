class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int index=n-1;
        while(index!=-1){
            if(digits[index]!=9){
                digits[index]+=1;
                return digits;
            }
            digits[index]=0;
            index--;
        }
        digits=new int[n+1];
        digits[0]=1;
        return digits;
        
    }
}