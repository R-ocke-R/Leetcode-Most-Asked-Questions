class Solution {
    public void bubbleSort(){}
    public void mergeSort(){}
    public void countSort(int[] arr){
        int n = arr.length;
        int minVal = Arrays.stream(arr).min().getAsInt();
        int maxVal = Arrays.stream(arr).max().getAsInt();

        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int val: arr){
            counts.put(val, counts.getOrDefault(val, 0) +1);
        }

        int index = 0;
        for(int val = minVal; val <= maxVal; ++val){
            while(counts.getOrDefault(val, 0) > 0){
                arr[index] = val;
                index += 1;
                counts.put(val, counts.get(val)-1);
            }
        }
        
    }
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] copy = Arrays.copyOf(heights, n);
        // Arrays.sort(copy);
        countSort(copy);

        int count = 0;
        for(int i = 0; i < n; i++){
            if(heights[i] != copy[i]) count++;
        }
        return count;
    }
}