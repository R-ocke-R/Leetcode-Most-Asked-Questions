class Solution {
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b){
            return a[1]-b[1];
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new myComparator());

        int n = intervals.length;
        int LastEndInterval = intervals[0][1];
        int count = 1;

        for(int i = 1; i < n; i++){
            int currStartInterval = intervals[i][0];
            if(currStartInterval >= LastEndInterval){
                count ++;
                LastEndInterval = intervals[i][1];
            }
        }
        return n-count;
    }
}