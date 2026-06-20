package sliding_window;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/description/">Leetcode Link</a>
 */
public class No2841 {
    public static long maxSum(List<Integer> nums, int m, int k) {
        long result = 0;
        long sum = 0;
        Map<Integer, Long> numMap = new HashMap<>();
        for (int right = 0; right < nums.size(); right++) {
            Long rightCount = numMap.get(nums.get(right));
            numMap.put(nums.get(right), Objects.isNull(rightCount) ? 1 : rightCount + 1);
            sum += nums.get(right);
            int left = right - k + 1;
            if (left < 0) {
                continue;
            }
            if (numMap.size() >= m) {
                result = Math.max(sum, result);
            }

            Long leftCount = numMap.get(nums.get(left));
            if (leftCount <= 1) {
                numMap.remove(nums.get(left));
            }else{
                numMap.put(nums.get(left), leftCount - 1);
            }
            sum -= nums.get(left);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(Arrays.asList(1, 2, 2), 2, 2));
        System.out.println(maxSum(Arrays.asList(1, 1, 1, 3), 2, 2));
        System.out.println(maxSum(Arrays.asList(2, 6, 7, 3, 1, 7), 3, 4));
        System.out.println(maxSum(Arrays.asList(5, 9, 9, 2, 4, 5, 4), 1, 3));
        System.out.println(maxSum(Arrays.asList(1, 2, 1, 2, 1, 2, 1), 3, 3));

    }
}
