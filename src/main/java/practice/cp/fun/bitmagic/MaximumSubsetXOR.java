//Given an set of positive integers. find the maximum XOR subset value in the given set. Expected time complexity O(n).
package practice.cp.fun.bitmagic;

import java.util.Arrays;

public class MaximumSubsetXOR {
   int arr[];
   int INT_MAX = 32;
   int n;
   public MaximumSubsetXOR(int[] arr) {
       this.arr = arr;
       this.n = arr.length;
   }

   public int getMaximumsubsetXORBySortingFirst() {
       Arrays.sort(this.arr);
       int index = 0;
       for (int i=INT_MAX -1; i>=0; i--) {
           int maxIndex = index;
           int maxEle = Integer.MIN_VALUE;
           for (int j=index; j<n; j++) {
               if ((arr[j] & (1 << i)) != 0) {
                   maxEle = arr[j];
                   if (j != index) {
                       int temp = arr[index];
                       arr[index] = arr[j];
                       arr[j] = temp;
                       maxIndex = index;
                   }
                   break;
               }
           }
           if (maxEle != Integer.MIN_VALUE) {
               for (int j = index + 1; j < n; j++) {
                   if ((arr[ j ] & (1 << i)) != 0 && j != maxIndex) {
                       arr[ j ] = arr[ j ] ^ maxEle;
                   }
               }
               index++;
           }
       }
       int res = 0;
       for (int i=INT_MAX -1; i>=0; i--) {
           int j = 0;
           if (j<n && (arr[ j ] & (1 << i)) != 0 && (res & (1 << i)) == 0) {
               res = res ^ arr[j];
               j++;
           }
       }
       return res;
   }

   public int getMaximumsubsetXOR() {
       int index = 0;
       for (int i=INT_MAX -1; i>=0; i--) {
           //finding the ith bit set
           int maxIndex = 0;
           int maxEle = Integer.MIN_VALUE;


           for (int j=index; j<n; j++) {
               if ((arr[j] & (1 << i)) != 0 && arr[j] > maxEle) {
                  maxEle = arr[j];
                  maxIndex = j;
               }
           }
           if (maxEle == Integer.MIN_VALUE) {
               continue;
           }
           int temp = arr[index];
           arr[index] = arr[maxIndex];
           arr[maxIndex] = temp;
           maxIndex = index;
           for (int j = 0; j < n; j++) {
               if ((arr[ j ] & (1 << i)) != 0 && j != maxIndex) {
                   arr[ j ] = arr[ j ] ^ arr[maxIndex];
               }
           }
           index++;
       }
       int res = 0;
       for (int j=0; j<n; j++) {
           res = arr[ j ] ^ res;
       }
       return res;
   }
}
