class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> array = new ArrayList<>();

        boolean flag = false;
        int n = intervals.length;

        int start = newInterval[0];
        int end = newInterval[1];

        int i = 0;

        while(i<n && start > intervals[i][1]){
            array.add(intervals[i]);
            i++;
        }
        while(i<n && end >= intervals[i][0]){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        array.add(new int[]{start, end});
        while( i < n){
            array.add(intervals[i]);
            i++;
        }
        return array.toArray(new int[array.size()][]);
    }
}