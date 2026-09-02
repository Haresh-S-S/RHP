import java.util.*;

public class D1DCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int loc[] = new int[n];
        int ppl[] = new int[n];
        for (int i = 0; i < n; i++) {
            loc[i] = sc.nextInt();
        }
        long presum[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ppl[i] = sc.nextInt();
            presum[i + 1] = presum[i] + ppl[i];
        }

        int q = sc.nextInt();
        while (q > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            long res = 0;

            int sin = lowerbound(loc, l);
            int ein = upperbound(loc, r);
            // if (l == 0) {
            // res = presum[ein + 1];

            // } else {
            res = presum[ein + 1] - presum[sin + 1];
            // }
            System.out.println(res);
            q--;
        }

    }

    public static int lowerbound(int[] arr, int tar) {
        int s = -1;
        int e = arr.length;

        while (s + 1 < e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] >= tar) {
                e = mid;
            } else {
                s = mid;
            }
        }

        return s;
    }

    public static int upperbound(int[] arr, int tar) {
        int s = -1;
        int e = arr.length;
        while (s + 1 < e) {
            int mid = (s + e) / 2;
            if (arr[mid] > tar) {
                e = mid;
            } else {
                s = mid;
            }
        }
        return s;
    }
}
