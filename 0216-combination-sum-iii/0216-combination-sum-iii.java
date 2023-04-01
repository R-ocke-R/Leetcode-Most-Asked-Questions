class Solution {
    public int mapping(int k){
        if(k==2) return 3;
        if(k==3) return 6;
        if(k==4) return 10;
        if(k==5) return 15;
        if(k==6) return 21;
        if(k==7) return 28;
        if(k==8) return 36;
        if(k==9) return 45;      
        return Integer.MIN_VALUE;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer= new ArrayList<>();
        List<Integer> dummy= new ArrayList<>();
        
        // edge cases
        if(mapping(k)<=n) function(k, n, answer, dummy, 0, 1);
        
        return answer;
        
    }
    public void function(int digits, int target, List<List<Integer>> answer, List<Integer> dummy, int sum, int i){
        // base case.
        if(sum==target && dummy.size()==digits){
            // add dummy to answer
            answer.add(new ArrayList<Integer>(dummy));
            return;
        }
        
        // function calling
        for(int index = i; index <= 9; index ++){
            if(index+sum<=target){
                dummy.add(index);
                function(digits, target, answer, dummy, sum+index, index+1);
                dummy.remove(dummy.size()-1);
            }
        }
        
        return;
        
        
    }
}