class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> jobProfile = new ArrayList<>();
        int n = difficulty.length;

        for(int i =0; i< n; i++){
            jobProfile.add(new int[] {difficulty[i], profit[i]});
        }

        //sort them  based on diff
        Collections.sort(jobProfile, (a, b) -> Integer.compare(a[0], b[0]));
        // sort worker as well
        Arrays.sort(worker);

        // prefix Max
        for (int i = 0; i < jobProfile.size() - 1; i++) {
            jobProfile.get(i + 1)[1] = Math.max(
                jobProfile.get(i)[1],
                jobProfile.get(i + 1)[1]
            );
        }

        int netProfit = 0, maxProfit = 0, index = 0;
        for(int i =0; i< worker.length; i++){
            int ability = worker[i];

            // finding the maxProfit 

            while(index < difficulty.length && worker[i] >= jobProfile.get(index)[0]){
                maxProfit = Math.max(maxProfit, jobProfile.get(index)[1]);
                index ++;
            }

            netProfit += maxProfit;
        }
        return netProfit;
    }
}