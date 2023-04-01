class Solution {
    public void function(int n, int k, List<List<Integer>> answer, List<Integer> dummy, int count, int i){
        // base case.
        if(count==k){
            // add dummy to answer
            answer.add(new ArrayList<Integer>(dummy));
            return;
        }
        
        // function calling
        for(int index = i; index <= n; index ++){
            dummy.add(index);
            function(n, k, answer, dummy, count+1, index+1);
            dummy.remove(dummy.size()-1);
            
        }
        
        return;
        
        
    }
        
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer= new ArrayList<>();
        List<Integer> dummy= new ArrayList<>();
        function(n, k, answer, dummy, 0, 1);
        return answer;
    }
}