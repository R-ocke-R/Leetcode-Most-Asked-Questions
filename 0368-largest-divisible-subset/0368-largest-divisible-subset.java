class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();
        
        for(int num:nums) dp.add(new ArrayList<>());
        for(int i = 0; i <nums.length; i++){
            List<Integer> dpmax= new ArrayList<>();
            for(int j=0; j<i; j++){
                
                // for nums[i] we check for all nums[j]
                if(nums[i]%nums[j]==0 && dpmax.size()< dp.get(j).size()){
                    // I take all the elements from nums[j] list.
                    dpmax=dp.get(j);
                }
            }
            dp.get(i).addAll(dpmax);
            dp.get(i).add(nums[i]);
        }
        
        List<Integer> answer= dp.get(0);
        for(int i=1;i<dp.size();i++){
            
            if(answer.size()<dp.get(i).size()) answer=dp.get(i);

        }
        return answer;
        
    }
}