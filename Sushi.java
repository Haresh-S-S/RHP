import java.util.*;
public class Sushi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] a = new int[M];
        for (int i = 0; i < M; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = sc.nextInt();
        }
        int count = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        int ai = M - 1;
        int bi = N - 1;
        while (ai >= 0 && bi >= 0) {
            if (b[bi] <= a[ai] * 2) {
                count++;
                bi--;
                ai--;
            } else {
                bi--;
            }
        }
        System.out.println(count);
    }
}