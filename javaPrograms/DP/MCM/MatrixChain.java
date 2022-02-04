
public class MatrixChain {

  static int table[][] = new int[1001][1001];

  static int recMcm(int[] arr, int i, int j) {

    if(i>=j) {
      return 0;
    }

    int mn = Integer.MAX_VALUE;

    for(int k=i; k<j; ++k) {
      int temp = recMcm(arr, i, k) + recMcm(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
      
      if(temp < mn) {
        mn = temp;
      }
    }

    return mn;
  }

  static void initializeTable() {
    for(int i=0; i<table.length; ++i) {
      for(int j=0; j<table[i].length; ++j) {
        table[i][j] = -1;
      }
    }
  }


  static int recMemoMcm(int[] arr, int i, int j) {
    
    if(table[i][j] != -1) {
      return table[i][j];
    }
    
    if(i>=j) {
      return table[i][j] = 0;
    }

    int mn = Integer.MAX_VALUE;

    for(int k=i; k<j; ++k) {
      int temp = recMemoMcm(arr, i, k) + recMcm(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];

      if(temp < mn) {
        mn = temp;
      }
    }

    return table[i][j] = mn;
  }

  public static void main(String[] args) {
    // int arr[] = {40, 20, 30, 10, 30};
    int arr[] = { 1, 2, 3, 4, 3 };

    // keep in mind : array size = number of matrices + 1

    int result = recMcm(arr, 1, arr.length - 1); // First matrix to last matrix
    System.out.println(result);

    initializeTable();

    int result2 = recMemoMcm(arr, 1, arr.length - 1);

    System.out.println(result2);
  }
}
