package practice.cp.fun.sort;

public class QuickSort {
    public QuickSort() {
    }

    public void quicksort(int[] arr, int m, int n) {
        if (m==n) {
            return;
        }
        int i = partition(arr, m, n);
        quicksort(arr, m, i);
        quicksort(arr, i+1, n);
    }

    private int partition(int[] arr, int m, int n) {
        int pivot = arr[m];
        arr[m] = arr[n];
        arr[n] = pivot;
        int i=m;
        int j=n-1;
        for (; i<j;) {
            if (arr[i] > pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            } else {
                i++;
            }
        }
        if (arr[i] > arr[n]) {
            int temp = arr[i];
            arr[i] = arr[n];
            arr[n] = temp;
        }
        return i;
    }
}
