public class RotatingArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        revarr(nums, 0, nums.length - 1);
        revarr(nums, 0, k - 1);
        revarr(nums, k, nums.length - 1);
    }

    public void revarr(int[] arr, int st, int en) {
        int s = st;
        int e = en;
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
