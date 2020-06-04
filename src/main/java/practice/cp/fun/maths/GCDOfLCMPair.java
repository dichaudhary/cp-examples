package practice.cp.fun.maths;

import java.util.Scanner;

public class GCDOfLCMPair {
    public static long getGcdOfLCMPair(long [] arr) {
        int n = arr.length;
        long []suff = new long[n];
        suff[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--) {
            suff[i] = findGCD(arr[i], suff[i + 1]);
        }
        long ans = (arr[0]*suff[1])/findGCD(arr[0], suff[1]);;
        for (int i=1; i<n-1; i++) {
           ans = findGCD(ans, (arr[i]*suff[i+1])/findGCD(arr[i], suff[i+1]));
        }
        return ans;
    }

    public static long findGCD(long a, long b) {
        //euclid algo
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return findGCD(a%b, b);
        return findGCD(a, b%a);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long [] arr = new long[n];
        for (int i=0; i<n; i++) {
            arr[i] = s.nextLong();
        }
        System.out.println(getGcdOfLCMPair(arr));
    }
}
