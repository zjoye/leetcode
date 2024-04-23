package org.array.minSubArrayLength;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 */
public class MinSubArrayLength {

    public static void main(String[] args) {
        int[] array = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        System.out.println(minSubArrayLen(15, array));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int windowSizes = 0;
        int windowSums = 0;
        for (int right = 0; right < nums.length; right++) {
            windowSums += nums[right];
            while (windowSums >= target) {
                windowSizes = right - left + 1;
                result = windowSizes < result ? windowSizes : result;
                windowSums -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
