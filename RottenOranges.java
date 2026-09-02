import java.util.LinkedList;

class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int oranges = 0, ans = 0;
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j, 0 });
                }
                if (grid[i][j] != 0) {
                    oranges++;
                }
            }
        }

        while (!q.isEmpty()) {
            int cell[] = q.poll();
            oranges--;
            int row = cell[0], col = cell[1], mins = cell[2];

            int[] dir = { 0, -1, 0, 1, 0 };

            for (int i = 0; i < 4; i++) {
                int ar = row + dir[i], ac = col + dir[i + 1];
                if (ar >= 0 && ar < R && ac >= 0 && ac < C && grid[ar][ac] == 1) {
                    q.add(new int[] { ar, ac, mins + 1 });
                    grid[ar][ac] = 2;
                }
            }
            ans = mins;
        }
        return oranges == 0 ? ans : -1;
    }
}