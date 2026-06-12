import java.util.Scanner;

public class Subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int l = str.length();
        for (int ct = 1; ct < (1 << l); ct++) {
            StringBuilder comb = new StringBuilder();
            for (int j = 0; j < l; j++) {
                if ((ct & (1 << j)) > 0) {
                    comb.append(str.charAt(j));
                }
            }
            System.out.println(comb);
        }
    }
}