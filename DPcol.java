import java.util.*;

class DPcol {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] arr = new int[row][col];
        int[][] dp = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < row; i++) {
            dp[i][0] = arr[i][0];
        }

        for(int j = 1; j < col; j++) {

            int[] info = fsMax(dp, j - 1, row);

            int maxValue = info[0];
            int maxRow = info[1];
            int secondMax = info[2];

            for(int i = 0; i < row; i++) {

                if(i == maxRow) {
                    dp[i][j] = arr[i][j] + secondMax;
                }
                else {
                    dp[i][j] = arr[i][j] + maxValue;
                }
            }
        }

        System.out.println("DP Matrix:");

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < row; i++) {
            answer = Math.max(answer, dp[i][col - 1]);
        }

        System.out.println("Maximum Sum = " + answer);
    }

    public static int[] fsMax(int[][] dp, int col, int row) {

        int maxValue = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int maxRow = -1;

        for(int i = 0; i < row; i++) {

            if(dp[i][col] > maxValue) {

                secondMax = maxValue;
                maxValue = dp[i][col];
                maxRow = i;
            }
            else if(dp[i][col] > secondMax) {

                secondMax = dp[i][col];
            }
        }

        return new int[]{maxValue, maxRow, secondMax};
    }
}