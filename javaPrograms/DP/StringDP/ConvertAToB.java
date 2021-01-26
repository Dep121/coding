
public class ConvertAToB {
  public static void main(String[] args) {
    String a = "heap";
    String b = "pea";

    // https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
    // Find minimum number of deletions and insertions to convert string a to b

    // Approach
    // find lcs i.e. "ea" then to convert a to b we have to remove "h" and "p" from string a and add "p"
    // and add "p" in begining of string a.

    // Conclusion
    // Number of deletions = a.length() - LCS(a, b)
    // Number of insertions = b.length() - LCS(a, b)

    int lcsLen = LCS.tableLCS(a, b);
    int numDel = a.length() - lcsLen;
    int numIns = b.length() - lcsLen;
    
    System.out.println("Number of Deletions required to convert string '" + a + "' to '" + b + "' is " + numDel);
    System.out.println("And Number of Insertions required to convert string '" + a + "' to '" + b + "' is " + numIns);
  }
}
