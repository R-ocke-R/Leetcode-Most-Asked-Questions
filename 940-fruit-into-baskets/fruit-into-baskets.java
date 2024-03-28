class Solution {
    public int totalFruitBruteTLE(int[] fruits) {

        HashSet<Integer> set = new HashSet<>();
        int maxL = 0;
        int n = fruits.length;
        
        for(int i = 0; i < n; i++){
            set = new HashSet<>();
            for(int j = i; j < n ; j++){
                set.add(fruits[j]);
                if(set.size() <= 2) {
                    // accepted
                    maxL = Math.max(maxL, j-i+1);
                }
                else {
                    break;
                }

            }
        }
        
        return maxL;
    }
    public int totalFruitBetter(int[] fruits){
        /** to optimise any subarray problem we use our sliding window technique
        in order to have sliding window in this question, we need to store the elements 
        a set won't work as be can't now either the locaiton or the last occurance
        now since there are two different elements here, 
        to aptly determine which of the 2 we need to remove from the window, so that we are able to expand the window
        and incorporate another element, we store frequency of the elements in map.
        
        when expanding we increase freq. when shrinking we decrese the freq till the map length is again 2.*/

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxL = 0;
        int n = fruits.length;

        int left = 0;
        int right = 0;
        
        while(right < n){
            int val  =  fruits[right];

            // expand window
            if(map.containsKey(val)) map.put(val, map.get(val)+1);
            else map.put(val, 1);

            // shrink window
            while(map.size() > 2){
                int remVal = fruits[left++];
                int remFreq = map.get(remVal);
                if(remFreq == 1) map.remove(remVal);
                else map.put(remVal, remFreq-1);
            }
            maxL = Math.max(maxL, right-left+1);
            right ++;
        }
        return maxL;
    }
    public int totalFruit(int[] fruits){
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxL = 0;
        int n = fruits.length;

        int left = 0;
        int right = 0;
        
        while(right < n){
            int val  =  fruits[right];

            // expand window
            if(map.containsKey(val)) map.put(val, map.get(val)+1);
            else map.put(val, 1);

            // shrink window
            if(map.size() > 2){
                int remVal = fruits[left++];
                int remFreq = map.get(remVal);
                if(remFreq == 1) map.remove(remVal);
                else map.put(remVal, remFreq-1);
            }
            // check and update
            else {
                maxL = Math.max(maxL, right-left+1);
            }
            right ++;
        }
        return maxL;
    }
}