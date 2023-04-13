class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;
        // base
        if(n==1) {List<Integer> answer= new ArrayList<>();
                  answer.add(nums[0]);
                  return answer;
                 }
        
        int majorityOne=0;
        int countOne=0;
        int majorityTwo=1;
        int countTwo=0;
        
        
        for(int i=0;i<n;i++){
            if(nums[i]==nums[majorityOne]){
                countOne++;
            }
            else if(nums[i]==nums[majorityTwo]){
                countTwo++;
            }
            else if(countOne == 0){
                majorityOne=i;
                countOne++;
            }
            else if(countTwo == 0){
                majorityTwo=i;
                countTwo++;
            }
            else {
                countOne--;
                countTwo--;
            }
        }
        
        // DOuble check because in this question its not necesary for both majority elements actually have more than n/3 occurances.
        countOne=0;
        countTwo=0;
        majorityOne=nums[majorityOne];
        majorityTwo=nums[majorityTwo];
        for(int i=0;i<n;i++){
            if(nums[i]==majorityOne) countOne++;
            if(nums[i]==majorityTwo) countTwo++;
        }
        List<Integer> answer= new ArrayList<>();
        if(countOne>n/3) answer.add(majorityOne);
        if(countTwo>n/3 && majorityOne!=majorityTwo) answer.add(majorityTwo);
        
        return answer;
    }
}