class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;

        int maxL = 0;
        
        // for(int i = 0; i < n; i++){
        //     set = new HashSet<>();
        //     for(int j = i; j< n ; j++){
        //         set.add(fruits[j]);
        //         if(set.size()<=2) maxL = Math.max(maxL, j-i+1);
        //         else break;
        //     }
        // }
        // return maxL;
        int right = 0;
        int left = 0;
        while(right < n){
            int fruit = fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0)+1);

            if(map.size() > 2){
                int remVal = fruits[left++];
                int remFreq = map.get(remVal);
                if(remFreq == 1) map.remove(remVal);
                else map.put(remVal, remFreq-1);
            }

            else {
                maxL = Math.max(maxL, right-left+1);
            }
            right++;

        }
        return maxL;
    }
}