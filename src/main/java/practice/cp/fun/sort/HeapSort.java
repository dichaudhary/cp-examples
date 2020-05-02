package practice.cp.fun.sort;

public class HeapSort {
    int[] arr;
    int n;
    int[] res ;

    public HeapSort(int[] arr, int n) {
        this.arr = arr;
        this.n = n;
        this.res = new int[n];
    }
   public int[] heapSort() {
       for (int i=n/2 -1; i>=0; i--) {
           heapify(i, n);
       }
       for (int i=n-1; i>=0; i--) {
           res[n-1-i] = arr[0];
           arr[0] = arr[i];
           heapify(0, i);
       }
       return res;
    }

    private void heapify(int k, int n) {
        for (int i = k; i < n; ) {
            int j = checkIfRightPos(i, n);
            if (j == i) {
                break;
            } else {
                i = j;
            }
        }
    }

    private int checkIfRightPos(int i, int m) {
        int min = arr[i];
        int l = 2*i + 1;
        int h = 2*i + 2;
        if ((l < m && min > arr[l]) || (h < m && min > arr[h])) {
            if (arr[ l] < arr[ h ]) {
                int temp = arr[ i ];
                arr[ i ] = arr[ l];
                arr[ l] = temp;
                i = l;
            } else {
                int temp = arr[ i ];
                arr[ i ] = arr[ h ];
                arr[ h ] = temp;
                i = h;
            }
            return i;
        }
        return i;
    }
}
