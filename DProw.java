import java.util.*;

class DProw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] arr = new int[row][col];
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int j = 0; j < col; j++) {
            dp[0][j] = arr[0][j];
        }

        for (int i = 1; i < row; i++) {

            int[] ans = fsMax(dp, i - 1, col);

            int firstMax = ans[0];
            int maxCol = ans[1];
            int secondMax = ans[2];

            for (int j = 0; j < col; j++) {

                if (j == maxCol) {
                    dp[i][j] = arr[i][j] + secondMax;
                } else {
                    dp[i][j] = arr[i][j] + firstMax;
                }
            }
        }

        System.out.println("DP Matrix:");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int maximum = Integer.MIN_VALUE;

        for (int j = 0; j < col; j++) {
            maximum = Math.max(maximum, dp[row - 1][j]);
        }

        System.out.println(maximum);
    }

    public static int[] fsMax(int[][] dp, int rowIdx, int col) {

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int maxCol = -1;

        for (int j = 0; j < col; j++) {

            if (dp[rowIdx][j] > firstMax) {

                secondMax = firstMax;
                firstMax = dp[rowIdx][j];
                maxCol = j;
            } else if (dp[rowIdx][j] > secondMax) {

                secondMax = dp[rowIdx][j];
            }
        }

        return new int[] { firstMax, maxCol, secondMax };
    }
}