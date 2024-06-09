class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        int n = hand.length;
        if(n % groupSize != 0 ) return false;

        Map<Integer, Integer> counter = new TreeMap<>();
        for(int i = 0; i< n; i++){
            counter.put(hand[i], counter.getOrDefault(hand[i], 0)+1);
        }

        while(counter.size() > 0){
            int card = counter.entrySet().iterator().next().getKey();
            for(int i = 0; i < groupSize; i++){
                // check if card is missing then can't make a group
                if(!counter.containsKey(card+i)) return false;
                // remove one occurance of the groupped card
                counter.put(card+i, counter.get(card+i)-1);
                //
                if(counter.get(card+i)==0) counter.remove(card+i);
            }
        }
        return true;
    }
}