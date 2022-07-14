class Solution {
    public int findDuplicate(int[] nums) {
//         int fast=nums[0];
//         int slow=nums[0];
//         do{
        
//             slow=nums[slow];
//             fast=nums[nums[fast]];
//         }while(slow!=fast);
        
//         fast=nums[0];
//         while(fast!=slow){
//             slow=nums[slow];
//             fast=nums[fast];
            
//         }
//         return slow;
        for(int i=0;i<nums.length;i++)
        {
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0){
                return index+1; //or math.abs(nums[i])
            }
            nums[index]=-(int)nums[index];
        }
        return -1;
    }
}