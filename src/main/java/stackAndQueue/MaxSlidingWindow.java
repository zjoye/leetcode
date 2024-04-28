package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow {
    /*public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int tmp = nums.length / k;
        int size = nums.length % k == 0 ? tmp / k : tmp + 1;
        int[] ret = new int[size];
        int windowsBorder = nums.length - k;
        int windowsMax = Integer.MIN_VALUE;
        for (int i = 0, j = i + k - 1; i <= windowsBorder; i++, j++) {
            // 1.窗口在最左侧时，从当前窗口找出最大值，存入数组。
            if (i == 0) {
                windowsMax = getMax(nums, i, j);
            } else {
                // 2.确定最大值是否窗口第一个值，若不是第一个值时，当窗口往右滑动后，仅需比较上一个窗口最大值与窗口末尾的值，谁大取谁为最大值。
                if (windowsMax != nums[i]) {
                    windowsMax = Integer.max(windowsMax, nums[j]);
                } else {
                    windowsMax = getMax(nums, i, j);
                }
            }
            ret[i] = windowsMax;
        }
        // 3.返回数组
        return ret;
    }*/
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> asQueue = new LinkedList<>();
        // 形成窗口前
        for (int i = 0; i < k; i++) {
            // 只要当前数组索引下表值小于队列末尾值，则将其移除队列。直到队列末尾值不小于当前数组索引下标值。
            while (!asQueue.isEmpty() && asQueue.peekLast() < nums[i]) {
                asQueue.removeLast();
            }
            asQueue.add(nums[i]);
        }
        result[0] = asQueue.peekFirst();
        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            if (!asQueue.isEmpty() && asQueue.peekFirst() == nums[i - k]) {
                asQueue.removeFirst();
            }
            // 只要当前数组索引下表值小于队顶值，则将其移除队列。直到队列末尾值不小于当前数组索引下标值。
            while (!asQueue.isEmpty() && asQueue.getLast() < nums[i]) {
                asQueue.removeLast();
            }
            asQueue.add(nums[i]);
            // 队顶值即窗口最大值
            result[i - k + 1] = asQueue.peekFirst();
        }
        return result;
    }


    public static void main(String[] args) {
        //System.out.println(getMax(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 0, 7));
        //System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        //System.out.println(maxSlidingWindow(new int[]{1, -1}, 1));
        //System.out.println(maxSlidingWindow(new int[]{7, 2, 4}, 2));
        System.out.println(maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4));

    }

    private static int getMax(int[] arr, int st, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = st; i <= end; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
