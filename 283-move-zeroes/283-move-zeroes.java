class Solution {
    public static void approach3(int[] arr){
        //optimisation of time complexity.
        
        int nonzero=0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]!=0){
                int temp=arr[nonzero];
                arr[nonzero]=arr[j];
                arr[j]=temp;
                nonzero++;

            }
        }
    }
    public void moveZeroes(int[] nums) {
        approach3(nums);
        
    }
}