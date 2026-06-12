import java.util.*;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string:");
		String s1 = sc.nextLine();
		System.out.println("Enter the second string:");
		String s2 = sc.nextLine();
		int max = 0;
		int r = s1.length();
		int c = s2.length();
		int a[][] = new int[r + 1][c + 1];
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					a[i][j] = 1 + a[i - 1][j - 1];
					if (a[i][j] > max) {
						max = a[i][j];
					}
				} else {
					a[i][j] = Math.max(a[i - 1][j], a[i][j - 1]);
				}
			}
		}
		System.out.println("The Longest common subsequence length is: " + max);
	}
}