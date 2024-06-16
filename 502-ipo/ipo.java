class Solution {
    private static class project{
        int capital;
        int profit;

        project(int capital , int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<project> proj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            proj.add(new project(capital[i], profits[i]));
        }

        Collections.sort(proj, (a, b) -> a.capital - b.capital);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);

        int i = 0;

        for(int j = 0; j < k; j++){
            while(i < n && proj.get(i).capital <= w){
                maxHeap.add(proj.get(i).profit);
                i++;
            }
            // everything in maxHeap can be used -> we use the maximum
            if(maxHeap.isEmpty()) break;

            w+= maxHeap.poll();
        }
        return w;       
        
    }
}