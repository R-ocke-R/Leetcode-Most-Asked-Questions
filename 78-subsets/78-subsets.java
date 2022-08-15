class Solution {
    public void answer(int[] nums, int index, List<Integer> pow, List<List<Integer>> ans){
        if(index==nums.length){
            ans.add(new ArrayList<Integer>(pow));
            return;
        }
        
        
        
        answer(nums, index+1, pow, ans);
        
        pow.add(nums[index]);
        answer(nums, index+1, pow, ans);
        pow.remove(pow.size()-1);
        
        return;
    }
    
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        answer(nums, 0, new ArrayList<Integer>(), list);
        return list;
        
    }
}