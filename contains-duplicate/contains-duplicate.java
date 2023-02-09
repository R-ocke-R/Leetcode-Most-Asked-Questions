class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for (Integer value : map.values()) {
            if(value>1) return true;
        }
        return false;        
    }
}

/* 
BRUTE: use O(n^2) two loops to check all permutations for duplicates
Approach 1: Use a map and start calculating the frequency of array elements, as soon as any freq>1; answer found
space and time-> o(N) 

approach 2: using as indices and marking with negatives, for duplicates; can't do it coz elements not from 0-n;

approach 2.1: sort...

approach 3:
use a set and check if set.size()==arr.size();
*/