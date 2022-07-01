class Solution {
    public static void approach3(int[] arr){
        //optimisation of time complexity.
        
        int i=0;//for zero.
        while(i<arr.length){
            if(arr[i]==0){
                //find next nonzero to swap with.
                for (int j = i; j < arr.length; j++) {
                    if(arr[j]!=0){
                        arr[i]=arr[j];
                        arr[j]=0;
                        break;
                    }
                    continue;
                }
                if(arr[i]==0){
                    break;//thus no more zero's
                }
            }
            else i++;
        }
        // System.out.println(Arrays.toString(arr));
    }
    public void moveZeroes(int[] nums) {
        approach3(nums);
        
    }
}