class SubsetSumWithGivenSum {

    static boolean table[][] = new boolean[20][20];

    public static boolean recSubsetSumWithGivenSum(int set[], int partialSum, int size) {
        if(partialSum == 0) {
            return true;
        }

        if(size == 0) {
            // for empty set 
            return false;
        }

        if(set[size-1] <= partialSum) {
            return recSubsetSumWithGivenSum(set, partialSum-set[size-1], size-1)
                || recSubsetSumWithGivenSum(set, partialSum, size-1);
        } else {
            // leave this element
            return recSubsetSumWithGivenSum(set, partialSum, size-1);
        }
    }

    public static boolean memoizeSubsetSumWithGivenSum(int set[], int partialSum, int size) {
        if(partialSum == 0) {
            table[size][partialSum] = true;
            return table[size][partialSum];
        }

        if(size == 0) {
            table[size][partialSum] = false;
            return table[size][partialSum];
        }

        if(table[size][partialSum] != -1) {
            return table[size][partialSum];
        }

        if(set[size-1] <= partialSum) {
            table[size][partialSum] = memoizeSubsetSumWithGivenSum(set, partialSum - set[size-1], size-1)
            ||  memoizeSubsetSumWithGivenSum(set, partialSum, size-1);
        } else {
            table[size][partialSum] = memoizeSubsetSumWithGivenSum(set, partialSum, size-1);
        }
        return table[size][partialSum];
    }

    public static void main(String[] args) {
        int set[] = {7, 4, 2, 9, 8};
        int sum = 16;

        boolean result = recSubsetSumWithGivenSum(set, sum, set.length);

        System.out.println(result);

        boolean memoizedResult = memoizeSubsetSumWithGivenSum(set, sum, set.length);
        System.out.println(memoizedResult);
    }
}
