import java.util.*;

class DeciBinaryNumbers {
    public int minPartitions(String n) {
        char[] ar = n.toCharArray();
        Arrays.sort(ar);
        return (ar[ar.length - 1] - '0');
    }
}