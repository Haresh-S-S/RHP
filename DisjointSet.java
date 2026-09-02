import java.util.*;

public class DisjointSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int lt = sc.nextInt();
            int rt = sc.nextInt();
            join(arr, lt, rt);

        }
        System.out.println(Arrays.toString(arr));
        TreeSet<Integer> set = new TreeSet<>();
        for (int j = 1; j < n + 1; j++) {
            set.add(arr[j]);
        }
        System.out.print("total no. of groups : " + set.size());
    }

    public static int find(int[] arr, int Node) {
        if (arr[Node] != Node) {
            arr[Node] = find(arr, arr[Node]);
        }
        return arr[Node];
    }

    public static void join(int[] arr, int left, int right) {
        int leftldr = find(arr, left);
        int rightldr = find(arr, right);
        arr[rightldr] = leftldr;
        // arr[leftldr] = rightldr;
    }
}
