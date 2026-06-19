package leetcode_hot100;

public class FirstMissingPositive {

    /**
     * 原地哈希
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        //1.遍历数组，让每个数组中的元素回到其数值-1的索引位置上
        for (int i = 0; i < nums.length; i++) {
            // 2.确保数据在(0,nums.length]区间，且数值不相同时交换位置（回到数值的索引所在地）
            while (nums[i] > 0 && nums[i] < nums.length + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
