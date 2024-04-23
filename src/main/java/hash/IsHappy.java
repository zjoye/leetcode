package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/happy-number/
 */
public class IsHappy {


    public int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int num = n % 10;
            n = n / 10;
            total += num * num;
        }
        return total;
    }

    public boolean isHappy(int n) {
        Set<Integer> existed = new HashSet<>();
        while (n != 1 && !existed.contains(n)) {
            existed.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public boolean isHappyByDoublePoint(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }
}
