package sliding_window;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/grumpy-bookstore-owner/">Leetcode Link</a>
 */
public class No1052 {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int[] leaveForAngryCustomers = new int[customers.length];
        for (int i = 0; i < customers.length; i++) {
            leaveForAngryCustomers[i] = customers[i] * grumpy[i];
        }
        int totalLeaves = Arrays.stream(leaveForAngryCustomers).sum();
        int totalCustomers = Arrays.stream(customers).sum();
        int maxMinuteSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int right = 0; right < leaveForAngryCustomers.length; right++) {
            currentSum += leaveForAngryCustomers[right];
            int left = right - minutes + 1;
            if (left < 0) {
                continue;
            }
            maxMinuteSum = Math.max(maxMinuteSum, currentSum);
            currentSum -= leaveForAngryCustomers[left];
        }
        int result = totalCustomers - totalLeaves + maxMinuteSum;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}
