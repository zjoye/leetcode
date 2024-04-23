package org.array.removeElement;

/**
 * https://leetcode.cn/problems/move-zeroes/
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 12};
        moveZeroes(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void moveZeroes(int[] nums) {
        // 1.处理边界
        if (nums == null || nums.length == 0) {
            return;
        }
        // 2.定义双指针，left表示
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }

    }
}
