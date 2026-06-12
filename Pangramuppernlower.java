import java.util.Scanner;

public class Pangramuppernlower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int lflag1 = 0;
        int uflag2 = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lflag1 = lflag1 | (1 << (ch - 'a'));
            }
            if (ch >= 'A' && ch <= 'Z') {
                uflag2 = uflag2 | (1 << (ch - 'A'));
            }
        }
        if (lflag1 == (1 << 26) - 1 && uflag2 == (1 << 26) - 1) {
            System.out.println("Yes");
        } else {
            System.out.println("NO");
        }
    }
}
