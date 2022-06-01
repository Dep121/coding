import java.util.*;

public class DFSGraph {

  int NUM_VERTICES;
  LinkedList<Integer> adj[];

  @SuppressWarnings("unchecked") DFSGraph(int numVertices) {
    NUM_VERTICES = numVertices;
    adj = new LinkedList[NUM_VERTICES];

    for (int i = 0; i < adj.length; i++) {
      adj[i] = new LinkedList<Integer>();
    }
  }

  void addEdge(int fromVertex, int toVertex) {
    adj[fromVertex].add(toVertex);
  }

  void DFSUtil(int startingVertex, boolean[] visited) {
    System.out.print(startingVertex + " ");
    visited[startingVertex] = true;
    Iterator<Integer> adjacentVertices = adj[startingVertex].listIterator();

    while(adjacentVertices.hasNext()) {
      int node = adjacentVertices.next();
      if(!visited[node]) {
        DFSUtil(node, visited);
      }
    }
  }

  void DFS(int startingVertex) {
    boolean visited[] = new boolean[NUM_VERTICES];

    DFSUtil(startingVertex, visited);
  }

  public static void main(String[] args) {
    DFSGraph g = new DFSGraph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    int startingVertex = 2;
    System.out.println("DFS search starting index: " + startingVertex);

    g.DFS(startingVertex);

  }
}
