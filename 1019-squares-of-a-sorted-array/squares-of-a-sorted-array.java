class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] newNums=new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int k=nums.length-1;
        while(i<=j){
            int s1=nums[i]*nums[i];
            int s2=nums[j]*nums[j];
            
            if(s1>=s2) {
                newNums[k--]=s1;
                i++;
            }
            else {
                newNums[k--]=s2;
                j--;
            }
        }
        return newNums;
    }
}