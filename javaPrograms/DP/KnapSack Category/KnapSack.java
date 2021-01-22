class Knapsack {

    static int table[][] = new int [20][20];

    public static int recuKnapsack(int weight[], int value[], int capacity, int item) {
        if(item == 0) {
            return 0;
        }

        // from choice diagram
        if(capacity - weight[item-1] >= 0) {
            return Math.max(
                // inlcude the item
                value[item-1] + recuKnapsack(weight, value, capacity - weight[item-1], item-1),
                // exclude the item
                recuKnapsack(weight, value, capacity, item-1)
                );
        } else {
            // not include this item
            return recuKnapsack(weight, value, capacity, item-1);
        }
    }

    public static int memoizeKnapsack(int weight[], int value[], int capacity, int item) {
        if (item == 0) {
            table[item][capacity] = 0;
            return table[item][capacity];
        }

        if(table[item][capacity] != -1) {
            return table[item][capacity];
        }

        if (weight[item-1] <= capacity) {
            table[item][capacity] = Math.max(
                // inlcude the item
                value[item-1] + recuKnapsack(weight, value, capacity - weight[item-1], item-1),
                // exclude the item
                recuKnapsack(weight, value, capacity, item-1)
                );
            return table[item][capacity];
        } else {
            table[item][capacity] = recuKnapsack(weight, value, capacity, item-1);
            return table[item][capacity];
        }
    }

    public static int tableKnapsack(int weight[], int value[], int capacity) {
        int items = weight.length;
        // initiliaze the table with base condition
        for(int i=0; i<items+1; ++i) {
            // bag capacity is zero then profit will be 0
            table[i][0] = 0;
        }

        for(int j=0; j<=capacity; j++) {
            // item are zero i.e. nothing to put in bag then again profit will be 0
            table[0][j] = 0;
        }

        for(int i=1; i<items+1; ++i) {
            for(int j=1; j<=capacity; ++j) {
                if(weight[i-1] <= j) {
                    table[i][j] = Math.max(value[i-1] + table[i-1][j-weight[i-1]],
                        table[i-1][j]
                        );
                } else {
                    table[i][j] = table[i-1][j];
                }
            }
        }

        return table[items][capacity];
    }

    public static void initialize(int table[][], int value) {
        for(int i=0; i<table.length; ++i) {
            for(int j=0; j<table[i].length; ++j) {
                table[i][j] = -1;
            }
        }
    }

    public static void printTable(int table[][]) {
        for(int[] array: table) {
            for(int ele: array) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int weight[] = {4, 2, 9, 7, 1};
        int value[] = {3, 9, 1, 5, 8};

        int capacity = 10;

        int maxProfit = recuKnapsack(weight, value, capacity, weight.length);

        System.out.println(maxProfit);

        initialize(table, -1);
        // printTable(table);

        int memoizeProfit = memoizeKnapsack(weight, value, capacity, weight.length);

        System.out.println(memoizeProfit);

        initialize(table, -1);
        System.out.println(tableKnapsack(weight, value, capacity));
        System.out.println(table[weight.length][capacity]);

    }
}
