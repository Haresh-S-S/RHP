import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] freq = new int[200001];
        int max = 0;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            freq[x]++;
            max = Math.max(max, x);
        }

        // cnt[i] = how many numbers have length >= i
        int[] cnt = new int[max + 2];

        for (int i = max; i >= 1; i--)
            cnt[i] = cnt[i + 1] + freq[i];

        StringBuilder ans = new StringBuilder();
        int carry = 0;

        for (int i = 1; i <= max; i++) {
            int sum = cnt[i] + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }

        while (carry > 0) {
            ans.append(carry % 10);
            carry /= 10;
        }

        System.out.println(ans.reverse());
    }
}