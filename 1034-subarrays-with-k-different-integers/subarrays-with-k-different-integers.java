class Solution {
    public int subarrayAtmost(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0 ;

        while(right < n){
            int val = nums[right];

            if(map.containsKey(val)) map.put(val, map.get(val)+1);
            else map.put(val, 1);

            // more than k
            while(map.size() > k){
                int value = nums[left++];
                int freq = map.get(value);
                if(freq == 1) map.remove(value);
                else map.put(value, freq-1);
            }
            // each new right value will are valid will not just make one subarray but will make multiple
            // based on where left pointer is.
            count += right - left + 1;

            right ++;
        }

        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        // implementing the better approach
        return subarrayAtmost(nums, k)- subarrayAtmost(nums, k-1);        
    }
}