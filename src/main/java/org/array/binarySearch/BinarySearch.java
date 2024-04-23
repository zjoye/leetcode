package org.array.binarySearch;

public class BinarySearch {
    /**
     * 输⼊: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     */
    public static void main(String[] args) {
        int[] array = {-1, 0, 3, 5, 9, 12};
        int[] a1 = {1,3,5,6};

        System.out.println(searchInsert(a1, 3));
    }

   /* public static int binarySearch(int[] nums, int target) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return -1;
        }
        int firstIndex = 0;
        int lastIndex = length - 1;
        while (length > 0) {
            int index = (firstIndex + lastIndex + 1) / 2;
            if (nums[index] > target) {
                //取左边
                lastIndex = index;
            } else if (nums[index] < target) {
                //取右边
                firstIndex = index;
            } else {
                return index;
            }
            length = length / 2;
        }
        return -1;
    }*/

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            if (nums[index] > target) {
                right = index-1;
            } else if (nums[index] < target) {
                left = index+1;
            } else {
                return index;
            }
        }
        return -1;
    }

    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int index = (left + right) / 2;
                if (nums[index] > target) {
                    right = index-1;
                } else if (nums[index] < target) {
                    left = index+1;
                } else {
                    return index;
                }
            }
            return -1;
        }
    }


}
