class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set  = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        int numMax = -1;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            if(num < 0){
                if(set.contains(Math.abs(num))) numMax = Math.max(numMax, Math.abs(num));
            }
        }
        return numMax;
    }
}