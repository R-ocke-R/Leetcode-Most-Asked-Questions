class Solution {
    public int minIncrementForUnique(int[] nums) {
        int incre =0;
        int n = nums.length;
        int maxEle = Arrays.stream(nums).max().getAsInt();

        int[] freqCount = new int[maxEle + n];
        // array to store the frq. 

        for(int i : nums){
            freqCount[i]++;
        }
        
        for(int i = 0; i < freqCount.length; i++){
            if(freqCount[i] > 1){
                int extra = freqCount[i]-1;
                incre += extra;
                freqCount[i+1] += extra;
            }
        }

        return incre;

    }
}