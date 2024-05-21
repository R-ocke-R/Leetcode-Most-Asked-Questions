class Solution {
    public void recursive(int[] nums, List<List<Integer>> answer, List<Integer> dummy, int i) {
        
        // base case
        if(i==nums.length) {
            answer.add(new ArrayList<>(dummy));
            return ;
        }

        recursive(nums, answer, dummy, i+1);

        dummy.add(nums[i]);
        recursive(nums, answer, dummy, i+1);
        dummy.remove(dummy.size()-1);  


        return;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> dummy = new ArrayList<>();
        recursive(nums, answer, dummy, 0);
        return answer;

        // int n = nums.length;

        // for(int i =0; i < n; i++){

        //     answer.add(new ArrayList<>(dummy));

        //     dummy.add(nums[i]);

        //     answer.add(new ArrayList<>(dummy));
        // }
        // return answer;
    }
}