class Solution {
    public int singleNumberSClinear(int[] nums) {
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
    public int singleNumberSCconstant(int[] nums){
        // this is a better approach, that doesn't take any space.
        // find explanation in notes
        int ans = 0;
        for(int bits =0; bits <= 31; bits ++){
            int count = 0;
            int bit = 1<<bits;
            for(int index = 0; index < nums.length; index ++){
                if((nums[index]&bit)!=0) count++;
            }
            if(count % 3 !=0) ans += (1<< bits);
        }
        return ans;
    }
    public int singleNumber(int[] nums){
        // best approach for this question, wonderful approach but don't expect to 
        // come to its intuition, I can explain why it works in the notes, but not how to reach to that approach
        // but all in all its a beautiful bit manipulation technique.
        int ones = 0;
        int twos = 0;
        // both of these will measure the occurance nums[i]; whether ones or twice
        // in the end all the triplets will cancel themselves using this beautiful bit technique

        for(int i = 0 ; i < nums.length ; i++){
            ones = (ones ^ nums[i]) & ~(twos);
            twos = (twos ^ nums[i]) & ~(ones);
        }    
        return ones;
    }
}