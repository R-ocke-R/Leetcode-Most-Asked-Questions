class Solution {
    public static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void answer(int index, List<List<Integer>> ans, int[] nums){
        if(index==nums.length) {
            ArrayList<Integer> dum=new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                dum.add(nums[i]);
            }
            ans.add(new ArrayList<>(dum));
            return;
        }
        // steps: we have to give chance to each element from index to size to sit at position index and rest recuriosn will do.
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            answer(index+1, ans, nums);
            swap(nums, index, i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        answer(0, ans, nums);
        return ans;
    }
}