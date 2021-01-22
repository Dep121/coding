class CountGivenSubsetSum {

    static int table[][] = new int[50][50];

    static int countSubsetWithGivenSum(int set[], int sum) {
        int size = set.length;
        // intialize the table
        for(int i=1; i<=sum; ++i) {
            // for empty set it is not possible to have sum >= 1.
            table[0][i] = 0;
        }

        for(int i=0; i<=size; ++i) {
            // 0 sum is possible in all the size of subset because every subset has empty subset
            table[i][0] = 1;
        }

        for(int i=1; i<=size; ++i) {
            for(int j=1; j<=sum; ++j) {
                if(set[i-1] <= j) {
                    table[i][j] = table[i-1][j - set[i-1]] + table[i-1][j];
                } else {
                    table[i][j] = table[i-1][j];
                }
            }
        }

        return table[size][sum];
    }

    public static void main(String[] args) {
        int set[] = {3, 5, 2, 9, 8};

        int sum = 5;

        System.out.println(countSubsetWithGivenSum(set, sum));

    }
}