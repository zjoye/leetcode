package leetcode_hot100;

import java.util.LinkedList;

public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        //单调最大队列，确保队列中只存储窗口中最大的值，且数据在队顶
        LinkedList<Integer> queue = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];

        // 左边界从  1-k  开始。left = right - k +1  -》 right=0即left = 1-k;
        for (int right = 0, left = 1 - k; right < nums.length; right++, left++) {
            // 判断在窗口形成后，即将移除窗口的数据是否为原窗口的最大值，若是最大值则将其移除。
            if (left > 0 && queue.peekFirst() == nums[left - 1]) {
                queue.removeFirst();
            }

            // 确保新加值是否比原来窗口最大值更大，若更大则清空替换。
            while (!queue.isEmpty() && queue.getLast() < nums[right]) {
                queue.removeLast();
            }

            // 存储队列
            queue.addLast(nums[right]);

            if (left >= 0) {
                result[left] = queue.getFirst();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,1,2,0,5};
        maxSlidingWindow(arr,3);
    }
}
