import java.io.*;
import java.util.*;

public class CIncDecXor {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        ArrayList<Integer> active = new ArrayList<>();

        int ans = 0;
        StringBuilder out = new StringBuilder();

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int x = Integer.parseInt(st.nextToken()) - 1;

                if (A[x] == 0)
                    active.add(x);

                ans ^= A[x] ^ (A[x] + 1);
                A[x]++;
            } 
            else {
                ArrayList<Integer> next = new ArrayList<>();

                for (int x : active) {
                    ans ^= A[x] ^ (A[x] - 1);
                    A[x]--;

                    if (A[x] > 0)
                        next.add(x);
                }

                active = next;
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}