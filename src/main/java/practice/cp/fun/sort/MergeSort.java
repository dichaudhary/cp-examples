package practice.cp.fun.sort;

public class MergeSort {
    int[] arr;
    int size;

    public MergeSort(int[] arr, int size) {
        this.arr = arr;
        this.size = size;
    }

    public int[] doMergeSort(int[] array, int m, int n) {
        if (n<=m) {
           int[] a = {array[m]};
           return a;
        }

        int[] a = doMergeSort(array, m, (n+m)/2);
        int[] b = doMergeSort(array, (n+m)/2 + 1, n);
        return merge(a, b);
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] res = new int[m+n];
        int k = 0;
        int i = 0;
        int j = 0;
        for (; i < m & j<n;) {
            if (arr2[j] <= arr1[i]) {
                res[k] = arr2[j];
                k++; j++;
            } else if (arr2[j] > arr1[i]) {
                res[k] = arr1[i];
                i++; k++;
            }
        }
        if (i<=m-1) {
            for (; i<m; i++, k++) {
                res[k] = arr1[i];
            }
        } else if (j<=n-1) {
            for (; j<n; j++, k++) {
                res[k] = arr2[j];
            }
        }
        return res;
    }
}
