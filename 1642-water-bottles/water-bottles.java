class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk = 0;
        int full = numBottles;
        int empty = 0;
        while(full+empty >= numExchange){
            drunk += full;
            empty += full;
            full = empty/numExchange;
            empty = empty%numExchange;
        }
        return drunk+full;
    }
}

// approach 1 brute force simulation