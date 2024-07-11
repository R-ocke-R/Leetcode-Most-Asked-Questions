class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;

        long waitingTime = 0;
        int cookTime = 0;

        for(int i = 0; i < n; i++){
            int[] client = customers[i];
            // if chef is free we start cooking and the wait time is only the cooking time
            if(client[0] >= cookTime){
                waitingTime += client[1];
                cookTime = client[0] + client[1]; 
                // cooking time will be starting time + time to cook
            }

            // if chef is busy the wait time is cooking + waiting difference time.
            else {
                
                waitingTime += cookTime - client[0]; // wait till chef is free
                waitingTime += client[1];
                cookTime += client[1];
            }


        }
        //System.out.println(waitingTime);
        double avg = (double) waitingTime / (double) n;
        return avg;
    }
}