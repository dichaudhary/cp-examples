package practice.cp.fun.misc;

import java.util.Arrays;
import java.util.Scanner;

public class MaxReforms {

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        long t = s.nextLong();
        long[] ans = new long[(int) t];
        for (long i = 0 ; i < t ; i++) {
            long n = s.nextLong();
            long x = s.nextLong();
            long[] money = new long[(int) n];
            for (int j = 0; j < n; j++) {
                money[j] = s.nextInt();
            }
            ans[(int) i] = calculateMaxReforms(money, x);
        }
        for (int k=0; k<t; k++) {
            System.out.println(ans[k]);
        }
    }

    private static long calculateMaxReforms(long[] money, long x) {
        long n = money.length;
        long[] final_money = new long[(int)n];
        long sum = 0;
        int k = (int)n-1;
        int l = 0;
        long positiveSum = 0;
        for (int i=0; i< n; i++) {
            money[i] = money[i] - x;
            if (money[i] >= 0) {
                sum = sum + money[i];
                positiveSum = positiveSum +1;
                final_money[k--] = money[i];
            } else {
                final_money[l++] = money[i];
            }
        }
        if (positiveSum == 0) {
            return 0;
        }
        //parallel sort
        sort(money, (int) (n));
        int j = (int) (n-positiveSum);
        long count = positiveSum;
        while (sum >= 0 && j>0) {
            j--;
            count++;
            sum = sum + money[j];
        }
        if (j==0 && (sum >= 0)) {
            return count;
        }
        return count-1;
    }

    public static void sort(long arr[], int n)
    {
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            long temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(long arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            long swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}