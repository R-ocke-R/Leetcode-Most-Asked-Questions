class Solution {
    public int maxSubarrayLengthBrute(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;
        int maxL = 0;

        for(int i = 0; i < n; i++){
            freqMap = new HashMap<>();
            for(int j = i; j< n; j++){
                int num = nums[j];
                int freq = freqMap.getOrDefault(num, 0) + 1;
                freqMap.put(num, freq);
                if(freq <= k) maxL =Math.max(maxL, j-i+1);
                else break;
            }
            
        }
        return maxL;
    }
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;
        int maxL = 0;

        int right = 0;
        int left = 0;
        while(right < n){
            int val = nums[right];
            int freq = freqMap.getOrDefault(val, 0) + 1;
            freqMap.put(val, freq);

            while(left <= right && freq > k) {
                // move left pointer. till we are able to remove one occurance of the curent val
                int value = nums[left++];
                int leftFreq =freqMap.getOrDefault(value, 0) -1;
                freqMap.put(value, leftFreq);

                if(value == val) freq = leftFreq;

            }
            if(freq <= k) maxL = Math.max(maxL, right - left + 1);
            right ++;
        }
    
        return maxL;
    }
}