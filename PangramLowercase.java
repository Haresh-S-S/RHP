import java.util.Scanner;

public class PangramLowercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int flag1 = 0;
        for (int i = 0; i < str.length(); i++) {
            flag1 = flag1 | (1 << (str.charAt(i) - 'a'));
        }
        if (flag1 == (1 << 26) - 1) {
            System.out.println("Yes");
        } else {
            System.out.println("NO");
        }
    }
}
