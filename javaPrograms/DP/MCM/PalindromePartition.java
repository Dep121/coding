
public class PalindromePartition {
  
  static int table[][] = new int[1001][1001];

  static boolean isPalindrome(String a, int i, int j) {
    int x=i, y=j;
    while(x<y) {
      if(a.charAt(x) == a.charAt(y)) {
        x++; y--;
      } else {
        return false;
      }
    }

    return true;
  }

  static int recPalPar(String a, int i, int j) {
    if(i>=j) {
      // for array size 1 eg. 'a' -> already palindrome therefore return 0
      // and for array size zero cannot palindrome
      return 0;
    }

    if(isPalindrome(a, i, j)) {
      // if string is already palindrome
      return 0;
    }
    
    int mn = Integer.MAX_VALUE;

    for(int k=i; k<j; ++k) {
      int temp = recPalPar(a, i, k) + recPalPar(a, k+1, j) + 1;

      mn = Math.min(temp, mn);
    }

    return mn;
  }

  static int recMemoPalPar(String a, int i, int j) {

    if(table[i][j] != -1) {
      return table[i][j];
    }

    if(i>=j) {
      // for array size 1 eg. 'a' -> already palindrome therefore return 0
      // and for array size zero cannot palindrome
      return table[i][j] = 0;
    }

    if(isPalindrome(a, i, j)) {
      // if string is already palindrome
      return table[i][j] = 0;
    }
    
    int mn = Integer.MAX_VALUE;

    for(int k=i; k<j; ++k) {
      int temp = recPalPar(a, i, k) + recPalPar(a, k+1, j) + 1;

      mn = Math.min(temp, mn);
    }

    return table[i][j] = mn;
  }

  static void initializeTable() {
    for(int i=0; i<table.length; ++i) {
      for(int j=0; j<table[i].length; ++j) {
        table[i][j] = -1;
      }
    }
  }

  public static void main(String[] args) {

    // find the minimum number of partitions of string so that each partitioned string is palindrome.
    String a = "nitikz";

    int result = recPalPar(a, 0, a.length()-1);
    System.out.println(result);

    initializeTable();

    int result2 = recMemoPalPar(a, 0, a.length() - 1);
    System.out.println(result2);
  }
}
