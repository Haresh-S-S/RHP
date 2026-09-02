import java.io.*;
import java.util.*;

public class CMinMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        long fixedPoints = 0;
        long swappedPairs = 0;
        
        for (int i = 1; i <= n; i++) {
            if (a[i] == i) {
                fixedPoints++;
            }
            int j = a[i];
            if (j > i && j <= n && a[j] == i) {
                swappedPairs++;
            }
        }
        long case1Pairs = (fixedPoints * (fixedPoints - 1)) / 2;
        long ans = case1Pairs + swappedPairs;
        
        System.out.println(ans);
    }
}
