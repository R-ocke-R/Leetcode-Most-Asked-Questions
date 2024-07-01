class Solution {
    public void traversal(int sNode , int[][] isConnected, boolean[] visited){

        Queue<Integer> queue = new LinkedList<>();
        int n = isConnected.length;
        queue.add(sNode);
        visited[sNode] = true;

        while(!queue.isEmpty()){
            Integer node = queue.poll();

            for(int i = 0; i < n; i++){
                if(isConnected[node][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count =0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                traversal(i, isConnected, visited);
            }
        }
        return count;
    }
}