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
            // improving the TC from 2n to n
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            // case 1 : empty
            if(ans.isEmpty()){
                ans.add(Arrays.asList(start,end));
                continue;
            }
            // case 2: included
            int prevEnd = ans.get(ans.size()-1).get(1);
            if(end <= prevEnd){
                continue;
            }
            // case 3 : excluded so include
            else if(start <= prevEnd){
                prevEnd = Math.max(end, prevEnd);
                ans.get(ans.size()-1).set(1, prevEnd);
            }
            // exclude so new 
            else {
                ans.add(Arrays.asList(start, end));
                
            }
        }
        int[][] array = ans.stream()
                                  .map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray())
                                  .toArray(int[][]::new);
        return array;
    }
}