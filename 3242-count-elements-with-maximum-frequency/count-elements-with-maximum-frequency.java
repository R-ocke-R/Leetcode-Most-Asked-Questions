class Solution {
    public int maxFrequencyElements(int[] nums) {
        // for the brute solution i can use a data structure to store key value frequencies
        // then sort on values, then store max freq count in a variable.

        // 
        int[] freq = new int[101];
        int maxfreq = 0;
        for(int i =0;i<nums.length;i++){
            freq[nums[i]]+=1;
            maxfreq = Math.max(freq[nums[i]], maxfreq);
        } 
        int count =0;
        for(int i=1;i<101;i++){
            if(freq[i]==maxfreq) count+=maxfreq;
        }
        //System.out.println(maxfreq);
        return count;

    }
}