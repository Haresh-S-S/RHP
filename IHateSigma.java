import java.util.*;

public class IHateSigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n], prev[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        long sum = 0, lsum = 0;
        for (int i = n - 1; i > -1; i--) {
            lsum -= prev[ar[i]];
            lsum += (prev[ar[i]] = n - i);
            sum += lsum;
        }
        System.out.print(sum);
    }
}
