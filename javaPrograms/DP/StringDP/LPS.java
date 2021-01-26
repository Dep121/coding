
public class LPS {
  public static void main(String[] args) {
    String a = "abctycbakjfo";

    // Find longest Palindromic subsequence
    // https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26
    
    // LPS length = LCS(a, reverse(a)).length()

    String b = new StringBuilder(a).reverse().toString();
    int lcsLen = LCS.tableLCS(a, b);

    System.out.println("Length of Palindromic substring is " + lcsLen);

    System.out.println("Palindromic string is '" + LCS.printLCS(a, b, LCS.table) + "'");

    // Minimum number of insertions in a string to make it palindrome
    // Minimum number of deletions in a string to make it palindrome
    // both are same

    // https://www.youtube.com/watch?v=AEcRW4ylm_c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=32

    int NumberOfDeletions = a.length() - lcsLen;
    System.out.println("Number of deletion or insertion to make '" + a + "' palindromic string is " + NumberOfDeletions);
  }
}
