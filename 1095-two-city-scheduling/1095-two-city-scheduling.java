class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b)-> {
            int diffa=a[0]-a[1]; int diffb=b[0]-b[1];
            if(diffa==diffb){
                return a[0]-b[0];
            }
            else {
                return diffa-diffb;
            }
        });
        int total= 0;
        for(int i=0;i<costs.length;i++){
            if(i<costs.length/2){
                total+=costs[i][0];
            }
            else {
                total+=costs[i][1];
            }
        }
        return total;
    }
}