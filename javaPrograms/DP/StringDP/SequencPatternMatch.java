
public class SequencPatternMatch {
  public static void main(String[] args) {
    String a = "hdju";
    String b = "kshkduiju";

    // https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=31
    
    // Find if string a is SubSequence of string b.

    // Approach
    // find the LCS and if the length of the LCS is equal to string a then
    // all the common letters are present in b from a and they are also of equal length
    // therefore  whole string a is in the b thus pattern is matched

    System.out.println("Is string '" + a + "' " + "is subSequence pattern of string '" + b + "'");
    System.out.println(LCS.tableLCS(a, b) == a.length());
  }
}
