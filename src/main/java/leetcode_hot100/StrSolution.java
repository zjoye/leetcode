package leetcode_hot100;

import java.util.HashMap;
import java.util.Map;

public class StrSolution {

    /**
     * 和为 K 的子数组
     *
     * @param nums
     * @param k
     * @return 1，-1，2，0，1，2
     */
    public int subarraySum(int[] nums, int k) {
        // 前缀和计数map
        Map<Integer, Integer> preNumCountMap = new HashMap<>();
        preNumCountMap.put(0, 1);
        //前缀和
        int preNum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            preNum += nums[i];
            // 若存在preNum -k 的值，意味着当前索引之前已经出现过 preNum - (preNum - k) = k 的最小子数组了。
            if (preNumCountMap.containsKey(preNum - k)) {
                result += preNumCountMap.get(preNum - k);
            }

            preNumCountMap.put(preNum, preNumCountMap.getOrDefault(preNum, 0) + 1);

        }
        return result;

    }
}
