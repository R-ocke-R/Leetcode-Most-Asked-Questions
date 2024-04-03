class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int freq = map.getOrDefault(nums[i], 0);
            map.put(nums[i], freq+1);
        }
        int maxFreq = 0;
        int maxEle = nums[0];
        for(Integer i : map.keySet()){
            if(map.get(i) > maxFreq ){
                maxFreq = map.get(i);
                maxEle = i;
            }
        }
        return maxEle;
    }
    public int majorityElementBest(int[] nums) {
        int majority=0;
        int count=1;
        
        for(int i=1;i<nums.length;i++){
            count += (nums[i]==nums[majority]) ? 1:-1;
            
            if(count==0) {
                majority=++i;
                count++;
            }
        }
        return nums[majority];
    }
}
