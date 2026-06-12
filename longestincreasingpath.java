import java.util.Scanner;

class longestincreasingpath {
    int[][] diff = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    private int dfs(int[][] matrix, int[][] dp, int R, int C, int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        int adjMax = 0;
        for (int i = 0; i < 4; i++) {
            int ar = row + diff[i][0];
            int ac = col + diff[i][1];
            if (ar >= 0 && ar < R && ac >= 0 && ac < C && matrix[ar][ac] > matrix[row][col]) {
                adjMax = Math.max(adjMax, dfs(matrix, dp, R, C, ar, ac));
            }
        }
        dp[row][col] = 1 + adjMax;
        return dp[row][col];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] dp = new int[R][C];
        int maxLen = 0;
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                maxLen = Math.max(maxLen, dfs(matrix, dp, R, C, row, col));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int R = sc.nextInt();
        System.out.print("Enter columns: ");
        int C = sc.nextInt();
        int[][] matrix = new int[R][C];
         System.out.println("Enter matrix elements:");

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        longestincreasingpath obj = new longestincreasingpath();
        int result = obj.longestIncreasingPath(matrix);
        System.out.println("Longest Increasing Path Length = " + result);
    }
}