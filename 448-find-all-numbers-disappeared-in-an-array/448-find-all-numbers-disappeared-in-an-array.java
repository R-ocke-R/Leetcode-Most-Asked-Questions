class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
//         using same approach like question to find all duplicateds in array as this also has the same vital information 
//         that integers are in the range [1, n]
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            // int index=Math.abs(nums[i])-1;
            if (nums[Math.abs(nums[i])-1]>0)
            nums[Math.abs(nums[i])-1]*=-1;
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++)
        {
            // int index=Math.abs(nums[i])-1;
            if (nums[i]>0) ans.add(i+1);
            
        }
        return ans;
        
    }
}