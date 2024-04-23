package org.array.binarySearch;

public class MySqrt {


    public static int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ret = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ret = mid;
                l = mid + 1;
            } else {
                r = mid - 1;

            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
