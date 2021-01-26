
public class LCS {

  static int t[][] = new int[20][20];
  static int table[][] = new int[20][20];

  static int recLCS(String a, String b, int m, int n) {
    // base Condition
    if(m == 0 || n == 0) {
      // if any of the length is 0 then common letters will be 0
      return 0;
    }

    // choice diagram
    if(a.charAt(m-1) == b.charAt(n-1)) {
      // if they are equal then we get a 1 character so increase count by 1
      // and move forward from both side
      return 1 + recLCS(a, b, m-1, n-1);
    } else {
      // if they are unequal then we have 2 choices
      // 1. move forward in a but not in b
      // 2. move forward in b but not in a
      // and collect both the result and compare which is returning longer sequence
      return Math.max(recLCS(a, b, m-1, n), recLCS(a, b, m, n-1));
    }
  }

  static int memoizeRecLCS(String a, String b, int m, int n) {
    // base condition
    if(m == 0 || n == 0) {
      return 0;
    }

    if(t[m][n] != -1) {
      return t[m][n];
    }

    if(a.charAt(m-1) == b.charAt(n-1)) {
      t[m][n] = 1 + memoizeRecLCS(a, b, m-1, n-1);
      return t[m][n];
    } else {
      t[m][n] = Math.max(memoizeRecLCS(a, b, m-1, n), memoizeRecLCS(a, b, m, n-1));
      return t[m][n];
    }
  }

  static int tableLCS(String a, String b) {
    // table size will be of a.length X b.length
    // initialize first row and column
    // if any of the string is empty then nothing is come so fill with 0.

    for(int i=0; i<a.length(); ++i) {
      table[0][i] = 0;
    }

    for(int i=0; i<b.length(); ++i) {
      table[i][0] = 0;
    }

    for(int i=1; i<=a.length(); ++i) {
      for(int j=1; j<=b.length(); ++j) {
        if(a.charAt(i-1) == b.charAt(j-1)) {
          table[i][j] = 1 + table[i-1][j-1];
        } else {
          table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
        }
      }
    }

    return table[a.length()][b.length()];
  }

  static String printLCS(String a, String b, int[][] t1) {
    int i = a.length(), j = b.length();
    StringBuilder str = new StringBuilder("");

    while(i > 0 && j > 0) {
      if(a.charAt(i-1) == b.charAt(j-1)) {
        str.append(a.charAt(i-1));
        i--;
        j--;
      } else if(t1[i-1][j] >= t1[i][j-1]) {
        i--;
      } else {
        j--;
      }
    }
    return str.reverse().toString();
  }

  static void initializeT() {
    for(int i=0; i<20; ++i) {
      for(int j=0; j<20; ++j) {
        t[i][j] = -1;
      }
    }
  }

  static void printTable(int[][] tb) {
    for(int i=0; i<tb.length; ++i) {
      for(int j=0; j<tb[i].length; ++j) {
        System.out.print(tb[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    String a = "avfkj";
    String b = "vaykoj";

    // Longest common subsequence top down (table approach)
    // https://www.youtube.com/watch?v=hR3s9rGlMTU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=21

    // Print Longest common subsequence
    // https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23

    // Find the length of longest common Subsequence in string a and b.
    // for example a = avfkj and b = vaykoj
    // vkj and akj are the longest common Subsequences

    System.out.println(recLCS(a, b, a.length(), b.length()));

    initializeT();
    System.out.println(memoizeRecLCS(a, b, a.length(), b.length()));

    System.out.println(printLCS(a, b, t));

    System.out.println(tableLCS(a, b));

    System.out.println(printLCS(a, b, table));
    
    // printTable(table);
  }
}
