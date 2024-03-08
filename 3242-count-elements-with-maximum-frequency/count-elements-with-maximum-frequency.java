class Solution {
    public int maxFrequencyElementsTwoPass(int[] nums) {
        // for the brute solution i can use a data structure to store key value frequencies
        // then store max freq count in a variable.

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
        return count;

    }
    /**  this here is my brute force solution, I took a 100 length array as a frequency storing DS, 
    I got the length as 100 from the constraints. then in the first pass I also maintained a variable 
    which can track the maxfreq that we have found till now.
    now we pass again to calculate the count of that maxfreq. 
    TC: o(n) SC: O(n) or o(100)=O(1)
    */
    public int maxFrequencyElements(int[] nums){
        // let's try to solve this in one pass; all I have to do is merge the function of the two passes above.
        int[] freq = new int[101];
        int maxfreq = 0;
        int count =0;
        for(int i =0;i<nums.length;i++){
            freq[nums[i]]+=1;
            if(freq[nums[i]]>maxfreq){
                // we have found a new maximumfreq
                maxfreq = freq[nums[i]];
                count = maxfreq;
                // count has now been reset
            }
            else if(freq[nums[i]]==maxfreq){
                // we have found another instance of maxfreq
                count += maxfreq;
            }
            else {continue;}
        } 
        return count;
    }
}