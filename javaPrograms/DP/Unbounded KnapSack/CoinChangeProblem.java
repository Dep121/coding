class CoinChangeProblem {

    static int table[][] = new int[20][20];

    static int countNumWays(int coin[], int sum) {
        int size = coin.length;
        // initialize the table.
        for(int i=1; i<=sum; ++i) {
            // row: for empty coin array i.e. with 0 number of coins we cannot make sum >= 1 therefore
            table[0][i] = 0;
        }

        for(int i=0; i<=size; ++i) {
            // col: we can make sum 0 using none of the coins so the number of way is 1.
            table[i][0] = 1;
        }

        for(int i=1; i<=size; ++i) {
            for(int j=1; j<=sum; ++j) {
                if(coin[i-1] <= j) {
                    table[i][j] = table[i-1][j] + table[i][j-coin[i-1]];
                } else {
                    table[i][j] = table[i-1][j];
                }
            }
        }

        return table[size][sum];
    }

    public static void main(String[] args) {
        int coin[] = {5, 2, 3};
        int sum = 5;

        // find the number of ways we can get the given sum by using the coins in the coin array. coins are unlimited of its kind.

        // similar to the count subset sum problem with multiple occurences.

        System.out.println(countNumWays(coin, sum));
    }
}