class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int compliment=target-nums[i];
            if(map.getOrDefault(compliment, -1)!=-1){
                return new int[]{map.get(compliment), i};
            }
            map.put(nums[i], i);
            
        }
        return new int[]{-1, -1};
    }
}