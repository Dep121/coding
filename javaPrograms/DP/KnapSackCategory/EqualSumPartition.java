class EqualSumPartition {

    static boolean table[][] = new boolean[50][50];

    static boolean givenSumInSubset(int set[], int sum) {
        int size = set.length;
        // initialize table
        for(int i=0; i<=size; ++i) {
            // for first col sum is 0.
            // for all the sizes of set there is always a empty subset which gives sum 0.
            table[i][0] = true;
        }

        for(int i=1; i<=sum; ++i) {
            // for first row we have empty set.
            // for empty set we cannot have sum >= 1.
            table[0][i] = false;
        }

        for(int i=1; i<=size; ++i) {
            for(int j=1; j<=sum; ++j) {
                if(set[i-1] <= j) {
                    table[i][j] = table[i-1][j - set[i-1]] || table[i-1][j];
                } else {
                    table[i][j] = table[i-1][j];
                }
            }
        }

        return table[size][sum];
    }

    public static void main(String[] args) {
        int set[] = {3, 3, 8, 6, 2};

        int sum = 7;

        // normal subset with given sum
        System.out.println( "Is sum " + sum + " exists ? " + givenSumInSubset(set, sum));

        // for equal partition
        // check if the total sum is even then it can be divided into two equal Natural Number otherwise equal partition does not exist.

        int totalSum = 0;
        for(int i=0; i<set.length; ++i) totalSum += set[i];

        System.out.print("Is equal partition for sum " + totalSum + " exists ? ");

        if(totalSum % 2 == 0) {
           System.out.println(givenSumInSubset(set, totalSum/2));
        } else {
          System.out.println(false);
        }

        // for minimum subset sum difference
        // use the last row which will tell which sum is possible.
        // run the loop on the set from 0 to half size to find the difference.

        givenSumInSubset(set, totalSum);
        int size = set.length;
        int mn = Integer.MAX_VALUE;

        System.out.println();
        for(int i=0; i<=totalSum/2; ++i) {
          if(table[size][i]) {
            System.out.print(" "+i);
            mn = Math.min(mn, totalSum - 2*i);
          }
        }

        System.out.println();


        System.out.println("Minimum sum difference is " + mn);

        // Given a subset sum difference count, how many subsets are possible
        // s1 - s2 = diff
        // s1 + s2 = totalSum
        // => s1 = (diff + totalSum) / 2
        //  find the count of s1
        int diff = 4;

        if((diff + totalSum) % 2 == 0) {
          int s1 = (diff + totalSum) / 2;
          System.out.println("count of subset with diff " + diff + " : " + CountGivenSubsetSum.countSubsetWithGivenSum(set, s1));
        }

        // Target sum
        // put the + and - sign in the elements of array such that there sum comes out 1, and how many such combinations are possible.

        // same as subset sum differemce count, just put the 1 value in diff.
    }
}
