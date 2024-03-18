class Solution {
    public int singleNumber(int[] nums) {
        /** Continuing from the previous question, single number 1; 
        let's first see the transferable approaches, before looking for more patterns
        HashMap and sort and check methods will work but very high computations.
        
        the bit manipulation using XOR isn't going to work anymore.
        the 4th appraoch using set and sum will work, let's try that even thought its not acceptable as it using extra space */
        Set<Long> set = new HashSet<>();
        int n = nums.length;
        long numsum = 0;
        for(int i = 0; i < n; i++){
            set.add((long)nums[i]);
            numsum += nums[i];
        }
        long setsum =0;
        for (Long i : set){
            setsum += i;
        }
        //System.out.println(numsum);
        return (int)((3*setsum-numsum)/2);

    }
}