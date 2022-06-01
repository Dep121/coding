import java.util.*;

/**
 * Graph
 */
public class BFSGraph {

  int NUM_VERTICES;
  LinkedList<Integer> adj[];

  BFSGraph(int numVertices) {
    NUM_VERTICES = numVertices;
    adj = new LinkedList[numVertices];

    for (int i = 0; i < adj.length; i++) {
      adj[i] = new LinkedList<Integer>();
    }
  }

  void addEdge(int fromVertex, int toVertex) {
    adj[fromVertex].add(toVertex);
  }
  
  void BFS(int startingVertex) {
    LinkedList<Integer> queue = new LinkedList<>();

    boolean visited[] = new boolean[NUM_VERTICES];
    queue.add(startingVertex);

    while(queue.size() != 0) {
      startingVertex = queue.poll();
      System.out.print(startingVertex + " ");
      visited[startingVertex] = true;

      Iterator<Integer> adjVertices = adj[startingVertex].listIterator();

      while(adjVertices.hasNext()) {
        int v = adjVertices.next();

        if (!visited[v]) {
          queue.add(v);
        }
      }
    }
  }
  
  public static void main(String args[]) {
    BFSGraph g = new BFSGraph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    int startingVertex = 2;
    System.out.println("Following BFS is starting from vertex: " + startingVertex);

    g.BFS(startingVertex);
  }
}