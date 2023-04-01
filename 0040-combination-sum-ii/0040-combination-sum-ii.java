class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer= new ArrayList<>();
        List<Integer> dummy= new ArrayList<>();
        
        
        // new
        
        Arrays.sort(candidates);
        
        function(candidates, target, answer, dummy, candidates.length, 0, 0);
        return answer;
    }

    public void function(int[] candidates, int target, List<List<Integer>> answer, List<Integer> dummy, int n, int sum, int i){
        // base case.
        if(sum==target){
            // add dummy to answer
            answer.add(new ArrayList<Integer>(dummy));
            return;
        }
        
        // function calling
        for(int index = i; index < n; index ++){
            if(sum+candidates[index]<=target){
                dummy.add(candidates[index]);
                function(candidates, target, answer, dummy, n, sum+candidates[index], index+1);
                dummy.remove(dummy.size()-1);
            }
            while(index!=n-1 && candidates[index+1]==candidates[index]){
                index++;
            }
        }
                
        return;
        
        
    }
}
