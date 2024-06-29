class Solution {
    private boolean placer(int[] position, int m, int mid){
        int prevBallPosition = position[0];
        int balls = 1;

        for(int i = 0; i< position.length && balls < m; i++){
            int currPos = position[i];
            if(currPos - prevBallPosition >= mid){
                //place a ball
                prevBallPosition = currPos;
                balls ++;
            }
        }
        return balls == m;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        int answer = 0;
        Arrays.sort(position);

        int low = 1;
        int end = (int) Math.ceil(position[n-1]/(m-1.0));

        while(low <= end){
            int mid = low + (end-low)/2;
            if(placer(position, m, mid)){
                answer = mid;
                low = mid + 1;
            }
            else end = mid -1;
        }
        return answer;
    }
}