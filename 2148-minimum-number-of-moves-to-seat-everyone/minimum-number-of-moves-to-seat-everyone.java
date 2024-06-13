class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int cost = 0;
        for(int i = 0; i < seats.length; i++){
            cost += Math.abs(seats[i] - students[i]);
        }
        return cost;
    }
}

/**


Can we greedily match each student to a seat?

the greedy matching appraoch takes about 20 seconds to code but how do you conduct its POC


 */