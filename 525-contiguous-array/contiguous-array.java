class Solution {
    public int findMaxLengthBrute(int[] nums) {
        int n = nums.length;
        int maxL = 0;

        int sum = 0;
        int currLen = 0;

        for(int i = 0; i < n; i++){
            sum = 0;
            for(int j = i; j < n; j++){
                sum+=nums[j];
                currLen = j-i+1;
                if(sum*2 == currLen){
                    maxL = Math.max(maxL, currLen);
                }
            }
        }
        return maxL;
    }
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxL = 0;

        int preSum = 0;
        int currLen = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        // stores preSum and first index of that sum

        for(int i = 0; i < n; i++){
            if(nums[i] == 0) preSum -= 1;
            else preSum += 1;
            if(preSum == 0) maxL = Math.max(maxL, i+1);
            if(map.containsKey(preSum)){
                // this sum has already been found 
                int first = map.get(preSum);
                maxL = Math.max(maxL, i-first);
            }
            else {
                map.put(preSum, i);
            }
        }
        return maxL;
    }
}