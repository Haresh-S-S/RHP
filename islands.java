import java.util.Scanner;

class islands {
    final int diff[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    private void dfs(char grid[][], int r, int c, int i, int j) {
        grid[i][j] = '0';
        for (int e = 0; e < 4; e++) {
            int ar = i + diff[e][0];
            int ac = j + diff[e][1];
            if (ar >= 0 && ar < r && ac >= 0 && ac < c && grid[ar][ac] == '1') {
                dfs(grid, r, c, ar, ac);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int island = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    dfs(grid, r, c, i, j);
                }
            }
        }
        return island;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int r = sc.nextInt();
        System.out.print("Enter columns: ");
        int c = sc.nextInt();
        char[][] grid = new char[r][c];
        System.out.println("Enter the grid (0 or 1):");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        islands obj = new islands();
        int result = obj.numIslands(grid);
        System.out.println("Number of Islands = " + result);
    }
}