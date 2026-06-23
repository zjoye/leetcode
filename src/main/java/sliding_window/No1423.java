package sliding_window;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/">Leetcode Link</a>
 */
public class No1423 {

    public static int maxScore(int[] cardPoints, int k) {
        int total = Arrays.stream(cardPoints).sum();
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;
        int window = cardPoints.length - k;
        if (cardPoints.length == k) {
            return total;
        }
        for (int right = 0; right < cardPoints.length; right++) {
            currentSum += cardPoints[right];
            int left = right - window + 1;
            if (left < 0) {
                continue;
            }
            minSum = Math.min(currentSum, minSum);
            currentSum -= cardPoints[left];
        }
        return total - minSum;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        System.out.println(maxScore(new int[]{1, 1000, 1}, 1));
        System.out.println(maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }

}
