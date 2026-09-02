import java.util.*;

class NotAllCovered {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] walls = new int[n + 2];

        for (int i = 0; i < t; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            walls[left] += 1;
            walls[right + 1] -= 1;

        }

        int ans = 20000001;
        int prefixsum = 0;
        for (int i = 1; i <= n; i++) {
            prefixsum += walls[i];
            ans = Math.min(ans, prefixsum);
        }

        System.out.print(ans);
    }
}
