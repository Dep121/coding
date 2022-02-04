import java.lang.reflect.Array;
import java.util.ArrayList;

public class twoSortedArrays {

  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

  public static void rec(int[] A, int[] B, int a, int b) {

    for(int i=a; i<A.length; ++i) {
      if(A[i] >= B[b]){
        for(int j=b; j<B.length; ++j) {
          if(B[j] >= A[i]) {
  
          }
        }
      }
    }

  }

  public static void main(String[] args) {
    int[] A = {10, 15, 25};
    int[] B = {1, 5, 20, 30};

    rec(A, B, 0, 0);
  }
}
