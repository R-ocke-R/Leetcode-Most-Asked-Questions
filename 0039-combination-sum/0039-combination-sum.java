class Solution {
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
                function(candidates, target, answer, dummy, n, sum+candidates[index], index);
                dummy.remove(dummy.size()-1);
            }
        }
        
        return;
        
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer= new ArrayList<>();
        List<Integer> dummy= new ArrayList<>();
        function(candidates, target, answer, dummy, candidates.length, 0, 0);
        return answer;
    }
}


/* 
  Intuition one: since any element can be taken unlimited number of times, there is no 
  sense of having duplicates. 
  
  wtf, dude ps says distinct. lol.
  
*/
