class Solution {
    public int findMinArrowShots(int[][] points) {
        int result  = 1;
        int n = points.length;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = 0;

        for(int current = 1; current < n ; current ++){
            if(points[prev][1] < points[current][0]){
                result++;
                // new arrow needed
                prev = current;
            }

        }




        return result;

    }
}
/** kinda merge intervals but kinda not - coz its ballons which can't be merged as they have been tied out
 */