
public class LRepeatingS {

  static int table[][] = new int[20][20];

  static int LRS(String a) {
    // initialization of row and column
    int l = a.length();
    for(int i=0; i<=l; ++i) {
      table[0][i] = 0; // first row
      table[i][0] = 0; // first column
    }

    for(int i=1; i<=l; ++i) {
      for(int j=1; j<=l; ++j) {
        if(a.charAt(i-1) == a.charAt(j-1) && i != j) {
          // i != j is the additional logic in LCS algorithm
          table[i][j] = 1 + table[i-1][j-1];
        } else if(table[i-1][j] > table[i][j-1]){
          table[i][j] = table[i-1][j];
        } else {
          table[i][j] = table[i][j-1];
        }
      }
    }
  
    return table[l][l];
  }

  static String printLRS(String a, int t[][]) {
    int i = a.length();
    int j = a.length();

    StringBuilder str = new StringBuilder("");

    while(i > 0 && j>0) {
      if(a.charAt(i-1) == a.charAt(j-1) && i != j) {
        str.append(a.charAt(i-1));
        i--;
        j--;
      } else if(t[i-1][j] > t[i][j-1]) {
        i--;
      } else {
        j--;
      }
    }

    return str.reverse().toString();
  }

  public static void main(String[] args) {
    String a = "abaukbcockau";

    // https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30

    // the subsequence is repeating so the second string will be string a itself.
    // Approach
    // find the LCS using same string and not consider the same position elements.

    System.out.println("LRS length of string '" + a + "' is " + LRS(a));

    System.out.println(printLRS(a, table));
  }
}
