class Solution {
    public static void approach2(int []arr){
        //using constant space + linear time complexity.
        //trying a modified bubble search at each iteration/round of bubble search i'll have a zero in the end
        for (int i = 0; i < arr.length-1; i++) {
            boolean count=false;
            for (int j = 0; j < arr.length-i-1; j++) {
                
                if(arr[j]==0){
                    // swap forward with arr[j+1]
                    count=true;arr[j]=arr[j+1];arr[j+1]=0;
                }
                
                
            }
            if (count==false){
                break;
            }
        }
        // System.out.println(Arrays.toString(arr));
    }
    public void moveZeroes(int[] nums) {
        approach2(nums);
        
    }
}