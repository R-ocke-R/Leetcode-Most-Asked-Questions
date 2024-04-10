class Solution {
    public int longestConsecutive(int[] nums) {
        // optimal approach
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);

        int best = 0;
        for(int n : set){
            if(!set.contains(n-1)){
                // doesn't contain n-1; means it could be the start of a new sequence
                int m = n+1;
                while(set.contains(m)){
                    m++;
                }
                best = Math.max(best, m-n);
            }
        }
        return best;
        
    }
}
