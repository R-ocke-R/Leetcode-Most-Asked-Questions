class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans= new ArrayList();
        for(int i=0; i<nums.length;i++){
//             the element is treated as index so creating a variable.
            int index= Math.abs(nums[i])-1;
//             checking if we have already visited the index. 
            if (nums[index]<0) ans.add(index+1);
//             if not then we negate the index.
            nums[index]=(int)-nums[index];
        }
        return ans;
    }
}