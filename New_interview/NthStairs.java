
public class NthStairs {

  static int countNumberOfWaysToCompleteStairSteps(int n, int[] res) {
    
    // base case
    res[0] = 1;
    res[1] = 1;
    res[2] = 2;

    for (int i = 3; i<=n; ++i) {
      res[i] = res[i-3] + res[i-2] + res[i-1];
    }
    return res[n];
  }

  static int fibonnaciMethod(int n) {
    int a = 1; // no of steps to reach at length 0
    int b = 1; // no of steps to reach at length 1
    int c = 2; // no of steps to reach at length 2
    int d = 0; // 

    if (n == 0) {
      return a;
    } else if (n == 1) {
      return b;
    } else if (n == 2) {
      return c;
    } else {
      for (int i=3; i<=n; ++i) {
        d = a + b + c;
        a = b;
        b = c;
        c = d;
      }
    }


    return d;
  }
  public static void main(String[] args) {
    int stairsSteps = 4;

    // number staris can be skipped 0, 1, 2

    int[] res = new int[8];
    System.out.println(countNumberOfWaysToCompleteStairSteps(stairsSteps, res));
    System.out.println(fibonnaciMethod(stairsSteps));
  }
}
