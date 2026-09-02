import java.util.*;

public class CRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int offset = 0;
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 1) {
                offset = (offset - b % n + n) % n;
            } else if (a == 2) {
                int realind = (offset + b - 1) % n;
                System.out.println(s.charAt(realind));
            }
        }
    }
}
