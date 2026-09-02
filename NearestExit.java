import java.util.*;

public class NearestExit {

    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { entrance[0], entrance[1], 0 });
        maze[entrance[0]][entrance[1]] = '+';

        int[][] dir = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int r = current[0];
            int c = current[1];
            int steps = current[2];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if (maze[nr][nc] == '+')
                    continue;

                // If we reach the boundary, it is an exit
                if (nr == 0 || nr == m - 1 ||
                        nc == 0 || nc == n - 1) {

                    return steps + 1;
                }

                maze[nr][nc] = '+';
                q.add(new int[] { nr, nc, steps + 1 });
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Main obj = new Main();

        char[][] maze = {
                { '+', '+', '.', '+' },
                { '.', '.', '.', '+' },
                { '+', '+', '+', '.' }
        };

        int[] entrance = { 1, 2 };

        System.out.println(obj.nearestExit(maze, entrance));
    }
}
