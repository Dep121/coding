
public class SCS {

  static int[][] table = new int[20][20];

  static String printSCS(String a, String b) {
    int lenA = a.length();
    int lenB = b.length();

    LCS.tableLCS(a, b);
    int i = lenA, j = lenB;

    StringBuilder str = new StringBuilder("");
    while(i>0 && j>0) {
      if(a.charAt(i-1) == b.charAt(j-1)){
        str.append(a.charAt(i-1));
        i--;
        j--;
      } else if(LCS.table[i-1][j] > LCS.table[i][j-1]) {
        str.append(a.charAt(i-1));
        i--;
      } else {
        str.append(b.charAt(j-1));
        j--;
      }
    }

    while(i>0){
      str.append(a.charAt(i-1));
      i--;
    }

    while(j>0){
      str.append(b.charAt(j-1));
      j--;
    }

    return str.reverse().toString();
  }

  static int lenSCS(String a, String b) {
    int lcsLength = LCS.tableLCS(a, b);
    int result = a.length() + b.length() - lcsLength;
    return result;
  }

  public static void main(String[] args) {
    String a = "kdhiwllkd";
    String b = "hwgekdd";

    // Short common SuperSequence
    // https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24

    // print short common subsequence
    // https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29

    // find the new shortest string which is having longest common subsequence of strings a and b
    
    System.out.println(lenSCS(a, b));

    System.out.println(printSCS(a, b));
  }
}
