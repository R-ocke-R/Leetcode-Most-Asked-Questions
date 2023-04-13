class Solution {
    public int[] productExceptSelf1(int[] nums) {
        int prod=1;
        boolean flag=true;
        for(int num : nums){
            if(num!=0) {
                prod *= num;
            }
            else {
                flag = false;
            }
        }
        for(int i= 0; i<nums.length;i++){
            if(nums[i]==0 ) nums[i]=prod;
            else if(flag==false) nums[i]=0;
            else nums[i] = prod/nums[i];
        }
        return nums;
    }
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] left = new int[n];
        int[] right= new int[n];
        
        left[0]=1;
        for(int i = 1; i < n; i++){
            left[i]=left[i-1]*nums[i-1];
        }
        
        
        right[n-1]=1;
        for(int i=n-2;i >= 0; i--){
            right[i]=right[i+1]*nums[i+1];
        }
        
        for(int i=0;i<n;i++){
            nums[i]=left[i]*right[i];
        }
        return nums;
    }
}


/*

This could be a simple linear solution if there wasn't a restriction on division

*/

