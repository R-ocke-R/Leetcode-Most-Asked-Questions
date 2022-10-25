class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> queue= new LinkedList<>();
        int[] ans= new int[n-k+1];
        // for the first k elements
        for(int i=0;i<k;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]){
                queue.removeLast();
            }
            queue.add(i);           
            
        }
        // for the remaining n-k elements
        for(int i=k;i<n;i++){
            // System.out.println(queue);
            // System.out.println(Arrays.toString(ans));
            //first we update for the last window
            ans[i-k]=nums[queue.peek()];
            // now updating the window indexes. removal code
            while(!queue.isEmpty() && i-queue.peek()>=k) queue.remove();
            // addition code
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]){
                queue.removeLast();
            }
            queue.add(i); 
            
            
        }
        ans[n-k]=nums[queue.peek()];
        return ans;
        
    }
}