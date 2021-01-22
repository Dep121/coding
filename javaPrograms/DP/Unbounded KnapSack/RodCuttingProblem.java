class RodCuttingProblem {

    // unbounded Knapsack problem
    // it is same as 0/1 Knapsack problem except the items can be repeated multiple times.

    static int table[][] = new int[20][20];

    static int maximumPrice(int rodLen[], int price[], int rodSize) {
        int numlengths = rodLen.length;
        // initialize the table
        for(int i=0; i<=rodSize; ++i) {
            // if rodLen array is empty i.e. not having the sizes which we need to cut into.
            table[0][i] = 0;
        }

        for(int i=0; i<=numlengths; ++i) {
            // if rod itself is of 0 length.
            table[i][0] = 0;
        }

        for(int i=1; i<=numlengths; ++i) {
            for(int j=1; j<=rodSize; ++j) {
                if(rodLen[i-1] <= j) {
                    // price[i-1] + table[i][j - rodLen[i-1]], do not decrement i
                    table[i][j] = Math.max(
                        price[i-1] + table[i][j - rodLen[i-1]],
                        table[i-1][j]);
                } else {
                    table[i][j] = table[i-1][j];
                }
            }
        }

        return table[numlengths][rodSize];
    }
    public static void main(String[] args) {
        int rodLen[] = {5, 2, 3, 4};    // similar to item array
        int price[] = {2, 3, 4, 6};     // similar to value array
        int rodSize = 10;               // similar to Capacity

        // cut the rod in given sizes mentioned in length array such that price of the rod can be maximize.

        System.out.println(maximumPrice(rodLen, price, rodSize));
    }
}