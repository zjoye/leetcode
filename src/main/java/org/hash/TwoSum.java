package org.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 ) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            int next = i == nums.length - 1 ? nums.length - 1 : i + 1;
            for (int j = next; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    public int[] twoSumByHashMap(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // k:value  v:index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int need = target - val;
            if (map.containsKey(need)) {
                return new int[]{i, map.get(need)};
            } else {
                map.put(val, i);
            }
        }
        return null;
    }
}
