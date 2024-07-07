class Solution {
    public int passThePillow(int n, int time) {
        int rounds = time/(n-1);
        int pillow = time % (n-1);

        if(rounds % 2 == 0) return pillow +1;
        return n-pillow;
    }
}

// condition1 : forward moving at tiem
// condition2 : backward moving at time