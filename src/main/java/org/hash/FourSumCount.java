package org.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/4sum-ii/
 */
public class FourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // k:出现的值；v:值出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        int result = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (map.containsKey(-nums3[i] - nums4[j])) {
                    result += map.get(-nums3[i] - nums4[j]);
                }
            }
        }
        return result;
    }
}
