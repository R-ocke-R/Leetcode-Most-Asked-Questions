class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare (int[] a, int[] b){
                return a[0]-b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i< n ; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            // case 1 : we have already included current element in some interval
            // se we check that
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }

            // case 2 : either ans is empty meaning this is the first inteval or
            //end of current is not lesser than the previous interval's end, thus its not part of the previous interval
            // we have to make new interval to include this.
            for(int j = i+1; j < n; j++){
                // if we can include the next interval
                if(intervals[j][0] <= end ){
                    end = Math.max(end, intervals[j][1]);
                }
                else{
                    // we have formed a new interval, no more intervals can be a part of this interval.
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        int[][] array = ans.stream()
                                  .map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray())
                                  .toArray(int[][]::new);
        return array;
    }
}