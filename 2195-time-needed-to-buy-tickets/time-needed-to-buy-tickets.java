class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the queue with ticket indices
        for (int i = 0; i < tickets.length; i++) {
            queue.add(i);
        }

        int time = 0;

        // Loop until the queue is empty
        while (!queue.isEmpty()) {
            // Increment the time counter for each iteration
            time++;

            // Get the front element of the queue
            int front = queue.poll();

            // Buy a ticket for the front person
            tickets[front]--;

            // If person k bought all their tickets, return time
            if (k == front && tickets[front] == 0) {
                return time;
            }

            // Re-add the current index to the queue for the next iteration
            if (tickets[front] != 0) {
                queue.add(front);
            }    
        }

        return time;
    }
}