import java.io.*;
import java.util.*;

public class DCoefficientStair {
    static int N, K;
    static int[] A;
    static StringBuilder output = new StringBuilder();

    static void dfs(int index, int remaining) {
        if (index == N - 1) {
            int position = index + 1;
            if (remaining % position == 0) {
                A[index] = remaining / position;
                for (int i = 0; i < N; i++) {
                    if (i > 0)
                        output.append(' ');
                    output.append(A[i]);
                }
                output.append('\n');
            }
            return;
        }
        int position = index + 1;
        for (int value = 0; value * position <= remaining; value++) {
            A[index] = value;
            dfs(
                    index + 1,
                    remaining - value * position);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        dfs(0, K);
        System.out.print(output);
    }
}
