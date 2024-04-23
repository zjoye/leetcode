package org.array.binarySearch;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：你可以设计并实现时间复杂度为 $O(\log n)$ 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * #思路
 */
public class BinarySearchRange {
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 7, 8, 8, 10};
        int leftBorder = leftBorderSearch(array, 8);
        int rightBorder = rightBorderSearch(array, 8);
    }

    /*public static int rightBorderSearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        int rightBorder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    public static int leftBorderSearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
                leftBorder = right;
            } else {
                left = mid + 1;
            }
        }
        return leftBorder;
    }*/

    public static int[] solution(int[] array, int target) {

        int leftBorderIndex = leftBorderSearch(array, 8);
        int rightBorderIndex = rightBorderSearch(array, 8);
        if (rightBorderIndex == -1 || leftBorderIndex == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{leftBorderIndex, rightBorderIndex};
    }


    public static int leftBorderSearch(int[] array, int target) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int leftBorderIndex = -1;
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (array[mid] == target) {
                leftBorderIndex = mid;
                endIndex = endIndex - 1;
            } else if (array[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return leftBorderIndex;
    }

    public static int rightBorderSearch(int[] array, int target) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int rightBorderIndex = -1;
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (array[mid] == target) {
                rightBorderIndex = mid;
                startIndex = startIndex + 1;
            } else if (array[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return rightBorderIndex;
    }
}
