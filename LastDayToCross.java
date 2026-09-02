import java.util.LinkedList;
import java.util.Queue;

class LastDayToCross {
    int row, col;

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row;
        this.col = col;

        int left = 1, right = cells.length, ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(mid, cells)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    boolean canCross(int day, int[][] cells) {

        int[][] grid = new int[row][col];

        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 0) {
                q.add(new int[] { 0, j });
                visited[0][j] = true;
            }
        }

        int[][] dir = {
                { 1, 0 }, { -1, 0 },
                { 0, 1 }, { 0, -1 }
        };

        while (!q.isEmpty()) {

            int[] current = q.poll();
            int r = current[0];
            int c = current[1];

            if (r == row - 1)
                return true;

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < row &&
                        nc >= 0 && nc < col &&
                        grid[nr][nc] == 0 &&
                        !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Main obj = new Main();

        int row = 2;
        int col = 2;

        int[][] cells = {
                { 1, 1 },
                { 2, 1 },
                { 1, 2 },
                { 2, 2 }
        };

        System.out.println(obj.latestDayToCross(row, col, cells));
    }
}