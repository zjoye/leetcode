package leetcode_hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductExceptSelf {

    /**
     * 超时！
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        Map<Integer, Integer> indexVal = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexVal.put(i, nums[i]);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            List<Integer> list = indexVal.entrySet().stream().filter(entry -> entry.getKey() != finalI).map(Map.Entry::getValue).collect(Collectors.toList());
            Integer tmp = null;
            for (Integer integer : list) {
                tmp = tmp == null ? integer : tmp * integer;
            }
            result[i] = tmp;
        }
        return result;
    }

    /**
     * 前后缀
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf_V2(int[] nums) {
        //第一个循环用于计算前缀积，第二个循环参与后缀积计算结果。
        int[] arr = new int[nums.length];
        // 初始化前缀第一个值
        arr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            arr[i] = nums[i - 1] * arr[i - 1];
        }
        //后缀第一个值默认1
        int rightVal = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 计算right右前缀积，同时计算结果
            arr[i] = rightVal * arr[i];
            rightVal = nums[i] * rightVal;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] ints = productExceptSelf_V2(arr);
    }

}
