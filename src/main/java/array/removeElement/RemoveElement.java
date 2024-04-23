package array.removeElement;

/**
 * https://leetcode.cn/problems/remove-element/description/
 */
public class RemoveElement {

    public static void main(String[] args) {
        //int[] array = {1, 2, 2, 3, 4, 2, 7};
        int[] array = {3};
        System.out.println(removeElement2(array, 2));

        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 双指针获取移除后的元素个数
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int elementsCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[elementsCount++] = nums[i];
            }
        }
        return elementsCount;
    }

    public static int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

}
