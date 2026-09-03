public class RotateString {
    public boolean rotateString(String s, String goal) {
        String to = goal + goal;
        if (to.contains(s)) {
            return true;
        }
        return false;
    }
}
