
public class ExpressionTrue {

  static int recEvaluateExpressionToTrue(String a, int i, int j, boolean isTrue) {
    //  Base Condition
    if(i>j) {
      return 0;
    }

    if(i==j) {
      if(isTrue) {
        return a.charAt(i) == 'T' ? 1 : 0;
      } else {
        return a.charAt(i) == 'F' ? 1 : 0;
      }
    }

    int ans = 0;

    for(int k=i+1; k<j; k+=2) {
      int lt = recEvaluateExpressionToTrue(a, i, k-1, true);
      int lf = recEvaluateExpressionToTrue(a, i, k-1, false);
      int rt = recEvaluateExpressionToTrue(a, k+1, j, true);
      int rf = recEvaluateExpressionToTrue(a, k+1, j, false);

      if(a.charAt(k) == '&') {
        if(isTrue) {
          ans += lt * rt;
        } else {
          ans += lt * rf + lf * rf + lf * rt;
        }
      } else if(a.charAt(k) == '|') {
        if(isTrue) {
          ans += lt * rt + lt * rf + lf * rt;
        } else {
          ans += lf * rf;
        }
      } else if(a.charAt(k) == '^') {
        if(isTrue) {
          ans += lt * rf + lf * rt;
        } else {
          ans += lt * rt + lf * rf;
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    String a = "T|T&F^T";

    // Find number of ways so that when we put brackets then expression evaluates to true.

    recEvaluateExpressionToTrue(a, 0, a.length()-1, true);
  }
}
