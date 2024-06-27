class Solution {
    public int findCenter(int[][] edges) {
        return (edges[0][0]==edges[1][0] || edges[0][0]== edges[1][1]) ? edges[0][0] : edges[0][1];
    }
}

// undirected
// the edges are given.. convert that to graph?



// the fuck the fucking 2 approach in editorial man.