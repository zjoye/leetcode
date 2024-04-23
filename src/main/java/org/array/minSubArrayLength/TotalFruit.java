package org.array.minSubArrayLength;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/fruit-into-baskets/
 */
public class TotalFruit {

    public static void main(String[] args) {
        int[] array = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(array));
    }

    public static int totalFruit(int[] fruits) {
        int left = 0;
        int typeSize = 2;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > typeSize) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                Integer afterCount = map.get(fruits[left]);
                if (afterCount == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            int windowSize = right - left + 1;
            result =  windowSize > result ? windowSize : result;
        }
        return result;
    }
}
