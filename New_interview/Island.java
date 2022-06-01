import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Island
 */
public class Island {

  static final int ROW = 5, COL = 5;

  boolean isSafe(int[][] M, int i, int j, boolean[][] visited) {
    return i<ROW && j<COL && i>=0 && j>=0 && M[i][j] == 1 && !visited[i][j];
  }

  void DFS(int[][] M, int i, int j, boolean[][] visited) {
    if (!isSafe(M, i, j, visited)){
      return;
    }
    visited[i][j] = true;
    // upward
      DFS(M, i-1, j, visited);
    // right
      DFS(M, i, j+1, visited);
    // left
      DFS(M, i, j-1, visited);
    // downward
      DFS(M, i+1, j, visited);
  }

  int countIslands(int M[][]) {

    boolean visited[][] = new boolean[ROW][COL];

    int count = 0;

    for(int i = 0; i<ROW; ++i) {
      for(int j = 0; j<COL; ++j) {
        if (M[i][j] == 1 && !visited[i][j]) {
          count++;
          DFS(M, i, j, visited);
        }
      }
    }

    return count;
  }

  public static void main(String[] args) throws java.lang.Exception {
    int M[][] = new int[][] { {1, 1, 0, 0, 0},
                              {0, 1, 0, 0, 1},
                              {1, 0, 0, 1, 1},
                              {0, 0, 0, 0, 0},
                              {1, 0, 1, 0, 1},};
    
    Island obj = new Island();
    System.out.println(obj.countIslands(M));


  }
}