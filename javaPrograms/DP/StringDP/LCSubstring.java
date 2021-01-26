
public class LCSubstring {

  static int t[][] = new int[20][20];
  static int table[][] = new int[20][20];

  static int recLCSSubstring(String a, String b, int m, int n, int count) {

    // base condition
    if(m == 0 || n == 0) {
      // if any of the string has length 0 then common letters will also be 0.
      return 0;
    }
    
    // choice diagram
    if(a.charAt(m-1) == b.charAt(n-1)) {
      // if both are equal then increase count by 1
      count = recLCSSubstring(a, b, m-1, n-1, count + 1);
    }
    
    count = Math.max(
      count,
      Math.max(
        recLCSSubstring(a, b, m-1, n, 0),
        recLCSSubstring(a, b, m, n-1, 0)
      )
    );
    return count;
  }

  static int recMemoizeLCSSubstring(String a, String b, int m, int n, int count) {

    // base condition
    if(m == 0 || n == 0) {
      // if any of the string has length 0 then common letters will also be 0.
      return 0;
    }

    if(t[m][n] != -1) {
      return t[m][n];
    }
    
    // choice diagram
    if(a.charAt(m-1) == b.charAt(n-1)) {
      // if both are equal then increase count by 1
      count = recLCSSubstring(a, b, m-1, n-1, count + 1);
    }
    
    count = Math.max(
      count,
      Math.max(
        recLCSSubstring(a, b, m-1, n, 0),
        recLCSSubstring(a, b, m, n-1, 0)
      )
    );

    t[m][n] = count;
    return count;
  }

  static int tableLCSubstring(String a, String b) {
    // row initialization
    for(int i=0; i<=a.length(); ++i) {
      table[0][i] = 0;
    }
    // column initialization
    for(int i=0; i<=b.length(); ++i) {
      table[i][0] = 0;
    }

    int result = 0;

    for(int i=1; i<=a.length(); ++i) {
      for(int j=1; j<=b.length(); ++j) {
        if(a.charAt(i-1) == b.charAt(j-1)) {
          table[i][j] = 1 + table[i-1][j-1];
          result = Math.max(result, table[i][j]);
        } else {
          table[i][j] = 0;
        }
      }
    }
    
    return result;
  }

  public static void main(String[] args) {
    String a = "jhabgtui";
    String b = "jhbogtuotuai";

    // Longest common Substring
    // https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22

    // Find the length of longest common substring in strings a and b

    System.out.println(recLCSSubstring(a, b, a.length(), b.length(), 0));

    // initialize t 2D array with -1

    for(int i=0; i<20; ++i) {
      for(int j=0; j<20; ++j) {
        t[i][j] = -1;
      }
    }

    System.out.println(recMemoizeLCSSubstring(a, b, a.length(), b.length(), 0));
    System.out.println(t[a.length()][b.length()]);

    System.out.println(tableLCSubstring(a, b));
  }
}
