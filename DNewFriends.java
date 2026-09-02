import java.util.*;

public class DNewFriends {
    int[] parent;
    int[] size;

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b)
            return;

        if (size[a] < size[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        parent[b] = a;
        size[a] += size[b];
    }

    public void solve(Scanner sc) {

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[][] friends = new int[m][2];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            friends[i][0] = a;
            friends[i][1] = b;

            union(a, b);
        }

        int[][] blocks = new int[k][2];

        for (int i = 0; i < k; i++) {
            blocks[i][0] = sc.nextInt() - 1;
            blocks[i][1] = sc.nextInt() - 1;
        }

        int[] friendCount = new int[n];

        for (int[] f : friends) {
            friendCount[f[0]]++;
            friendCount[f[1]]++;
        }

        int[] blockCount = new int[n];

        for (int[] b : blocks) {
            if (find(b[0]) == find(b[1])) {
                blockCount[b[0]]++;
                blockCount[b[1]]++;
            }
        }

        for (int i = 0; i < n; i++) {

            int componentSize = size[find(i)];

            int answer = componentSize - 1
                    - friendCount[i]
                    - blockCount[i];

            System.out.print(answer + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        obj.solve(sc);
    }
}