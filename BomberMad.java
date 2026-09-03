import java.io.*;
import java.util.*;

public class BomberMad {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] grid = new char[H][W];

        for (int i = 0; i < H; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        boolean[] safeRow = new boolean[H];
        boolean[] safeCol = new boolean[W];

        Arrays.fill(safeRow, true);
        Arrays.fill(safeCol, true);

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (grid[i][j] == '#') {
                    safeRow[i] = false;
                    break;
                }
            }
        }

        for (int j = 0; j < W; j++) {
            for (int i = 0; i < H; i++) {
                if (grid[i][j] == '#') {
                    safeCol[j] = false;
                    break;
                }
            }
        }

        int[][] dist = new int[H][W];

        for (int i = 0; i < H; i++)
            Arrays.fill(dist[i], -1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            if (!safeRow[i])
                continue;

            for (int j = 0; j < W; j++) {
                if (grid[i][j] == '.' && safeCol[j]) {
                    dist[i][j] = 0;
                    q.add(new int[] { i, j });
                }
            }
        }

        if (q.isEmpty()) {
            System.out.println(0);
            return;
        }

        int[][] dir = {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];

                if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                    if (grid[nr][nc] == '.' && dist[nr][nc] == -1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (grid[i][j] == '.' && dist[i][j] != -1
                        && dist[i][j] <= K) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
