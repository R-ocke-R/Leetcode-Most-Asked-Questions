class Solution {
    public int majorityElementBetter(int[] nums) {
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
    public int majorityElement(int[] nums) {
        int majority = 0;
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
            if(count==0) {
                majority=nums[i];
                count++;
            }
            else if(nums[i] == majority) count ++;
            else count--;             
        }
        return majority;
    }
}
