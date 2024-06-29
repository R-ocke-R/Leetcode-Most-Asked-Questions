class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int n = difficulty.length;

        int maxAbility = Arrays.stream(worker).max().getAsInt();
        int[] jobs = new int[maxAbility+1];

        // 
        for (int i = 0; i < difficulty.length ; i++) {
            if(difficulty[i] <= maxAbility){
                jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
            }
        }
        for(int i =1 ; i <= maxAbility; i++){
            jobs[i] = Math.max(jobs[i], jobs[i-1]);
        }

        int netProfit = 0;
        for(int i =0; i< worker.length; i++){
            int ability = worker[i];

            netProfit += jobs[ability];
        }
        return netProfit;
    }
}