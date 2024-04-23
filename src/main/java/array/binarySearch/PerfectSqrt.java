package array.binarySearch;

public class PerfectSqrt {
    public static boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long square = (long) mid * mid;
            if (square > num) {
                r = mid - 1;
            } else if (square < num) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
    }
}
