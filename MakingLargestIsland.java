import java.util.*;

public class MakingLargestIsland {

    static int n;

    public static int largestIsland(int[][] grid) {
        n = grid.length;

        Map<Integer, Integer> area = new HashMap<>();
        int id = 2;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, id);
                    area.put(id, size);
                    max = Math.max(max, size);
                    id++;
                }
            }
        }

        int[][] dir = {
                { 1, 0 }, { -1, 0 },
                { 0, 1 }, { 0, -1 }
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    int size = 1;
                    Set<Integer> seen = new HashSet<>();

                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];

                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            int islandId = grid[x][y];

                            if (islandId > 1 && seen.add(islandId)) {
                                size += area.get(islandId);
                            }
                        }
                    }

                    max = Math.max(max, size);
                }
            }
        }

        return max;
    }

    static int dfs(int[][] grid, int i, int j, int id) {

        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1)
            return 0;

        grid[i][j] = id;

        return 1
                + dfs(grid, i + 1, j, id)
                + dfs(grid, i - 1, j, id)
                + dfs(grid, i, j + 1, id)
                + dfs(grid, i, j - 1, id);
    }

    public static void main(String[] args) {

        int[][] grid = {
                { 1, 0 },
                { 0, 1 }
        };

        System.out.println(largestIsland(grid));
    }
}
