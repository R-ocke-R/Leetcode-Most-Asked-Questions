class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> circle = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            circle.add(i);
        }

        int startIndex = 0;
        while(circle.size() > 1){
            int remIndex = (startIndex + k - 1) % circle.size();

            circle.remove(remIndex);

            startIndex = remIndex;
        }

        return circle.getFirst();
        
    }
}

// can't traverse using an array of length n
// let's try with an LinkedList.



/**
while (circle.size() > 1) {
            // Process the first k-1 friends without eliminating them
            for (int i = 0; i < k - 1; i++) {
                circle.add(circle.remove());
            }
            // Eliminate the k-th friend
            circle.remove();
        }

Good queue approach

 */