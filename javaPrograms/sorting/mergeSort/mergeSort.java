// merge sort

class mergeSort {

    static int inversionControl = 0;

    static void merge(int[] ar, int p, int mid, int q) {
        int l1 = mid - p + 1;
        int l2 = q - mid;

        int i = 0, j = 0, k = 0;

        int a[] = new int[l1 + l2];

        while(i < l1 && j < l2) {
            if(ar[p + i] < ar[mid + 1 + j]) {
                a[k] = ar[p + i];
                i++;
            } else {
                a[k] = ar[mid + 1 + j];
                j++;
            }
            k++;
        }

        if(i == l1) {
            while(j < l2) {
                a[k] = ar[mid + 1 + j];
                j++; k++; inversionControl++;
            }
        }

        if(j == l2) {
            while(i < l1) {
                a[k] = ar[p + i];
                i++; k++;
            }
        }

        for(int s = p, t = 0; s <= q; ++s, ++t){
            ar[s] = a[t];
        }
    }

    static void sort(int[] ar, int p, int q) {
        if(p >= q) return;
        int mid = (p+q)/2;

        sort(ar, p, mid);
        sort(ar, mid+1, q);

        merge(ar, p, mid, q);
    }

    public static void main(String[] args) {
        // int[] ar = {7, 5, 8, 2, 1, 6};
        int[] ar = {2, 4, 1, 3, 5};

        for (int ele : ar) {
            System.out.print(ele + " ");
        }
        System.out.println();

        sort(ar, 0, ar.length-1);

        for (int ele : ar) {
            System.out.print(ele + " ");
        }
        System.out.println();

        System.out.println(inversionControl);

    }
}