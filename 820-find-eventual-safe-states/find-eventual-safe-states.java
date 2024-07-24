class Solution {
    public boolean dfs(int i, int[][] graph, boolean[] va, boolean[] path){
        // if cycle is found or already visted is marked from before - this means that
        // they are part of a loop and thus they aren't "back - updated " to false in path + va
        if(path[i]) return true; // cycle can be found now.
        if(va[i]) return false; // no cycle but we have visited this before

        va[i] = true;
        path[i] = true;

        for(int neig : graph[i]){
            if(dfs(neig, graph, va, path)) return true;
        }
        path[i] = false;
        // if we are here for i there was no relation with any cycles and thus they are safe nodes
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] va = new boolean[n];
        boolean[] path = new boolean[n];

        for(int i = 0; i < n; i ++){
            dfs(i, graph, va, path);
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!path[i]) answer.add(i);
        }
        return answer;
    }
}