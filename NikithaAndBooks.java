import java.util.Scanner;

public class NikithaAndBooks {
    public static void main(String[] args) {
        // int bal = 0;
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int j = 1; j <= q; j++) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                arr[i] = sc.nextInt();
            }
            boolean yes = true;
            long bal = 0;
            for (int i = 1; i <= n; i++) {
                if (i == arr[i])
                    continue;
                if (arr[i] < i) {
                    int req = i - arr[i];
                    if (bal >= req) {
                        // int req = i - arr[i];
                        bal = bal - req;
                        if (bal < 0) {
                            yes = false;
                            break;
                        }
                    } else {
                        yes = false;
                        break;
                    }
                }
                if (arr[i] > i) {
                    int rem = arr[i] - i;
                    bal = bal + rem;
                }
            }
            System.out.println(yes ? "YES" : "NO");
        }
    }
}
