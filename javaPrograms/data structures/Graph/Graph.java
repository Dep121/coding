import java.util.*;

class Graph {
    private int v;  // number of vertices
    private LinkedList<Integer> adj[];  // adjacency list

    Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];

        for (int i=0; i<v; ++i) {
            this.adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w) {
        this.adj[v].add(w);
    }

    void DFSTraversal(int v) {
        boolean[] visited = new boolean[this.v];

        DFSUtil(v, visited);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v);

        Iterator<Integer> it = this.adj[v].listIterator();

        while(it.hasNext()) {
            int n = it.next();

            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void BFS(int v) {
        boolean[] visited = new boolean[this.v];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[v] = true; // make visited true as soon as you add
        // to prevent the visited node form being added
        queue.add(v);

        while(queue.size() != 0) {
            int s = queue.poll();

            System.out.println(s);

            Iterator<Integer> it = this.adj[s].listIterator();

            while(it.hasNext()){
                int n = it.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)");
        g.DFSTraversal(2);
    }
}