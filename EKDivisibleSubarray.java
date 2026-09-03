import java.io.*;
import java.util.*;

public class EKDivisibleSubarray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];

        int rem = 0;

        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int curr = Integer.parseInt(st.nextToken());

            rem = (rem + curr) % K;

            if (m.containsKey(rem)) {
                int previdx = m.get(rem);
                dp[i] = Math.max(dp[i - 1], 1 + dp[previdx]);
            } else {
                dp[i] = dp[i - 1];
            }

            m.put(rem, i);
        }

        System.out.println(dp[N]);
    }
}
