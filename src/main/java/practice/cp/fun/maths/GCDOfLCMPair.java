package practice.cp.fun.maths;

import java.util.Scanner;

public class GCDOfLCMPair {
    public static long getGcdOfLCMPair(long [] arr) {
        int n = arr.length;
        long ans = 0;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                long gcd = findGCD(arr[ i ], arr[ j]);
                ans = findGCD(ans, ((arr[ i ] * arr[ j]) / gcd));
            }
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
