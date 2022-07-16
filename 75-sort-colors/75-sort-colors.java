class Solution {
    public void sortColors(int[] nums) {
        int i =0;
        int j= nums.length-1;
        int index=0;
        while(index<=j){
            // if(nums[i]==0)++i;continue;
            // if(nums[j]==2)--j;continue;
            if(nums[index]==2){
                swap(nums, index, j); --j;
            }
            else if (nums[index]==0){
                if(index==i){
                    ++i;
                    ++index;
                    continue;
                }
                swap(nums, index, i); i++;
            }
            else {
                index++;
            }
            // System.out.println(Arrays.toString(nums));
            
        }
        
    }
    public static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        return;
    }
}