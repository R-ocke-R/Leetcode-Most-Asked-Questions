class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int low = 0;
        int high = tokens.length - 1;
        int score = 0;
        Arrays.sort(tokens);

        while (low <= high) {
            // When we have enough power, play lowest token face-up
            if (power >= tokens[low]) {
                score += 1;
                power -= tokens[low];
                low += 1;
            // We don't have enough power to play a token face-up
            // If there is at least one token remaining,
            // and we have enough score, play highest token face-down
            } else if (low < high && score > 0) {
                score -= 1;
                power += tokens[high];
                high -= 1;
            // We don't have enough score, power, or tokens 
            // to play face-up or down and increase our score
            } else {
                return score;
            }
        }
        return score;
    }
}

/* chance one does calls for playing all the tokens[i] that are smaller than power, pllay them face up, gain the score.

... there are a lot of permutations available. 
*/