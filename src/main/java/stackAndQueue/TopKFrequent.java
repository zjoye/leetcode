package stackAndQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        //1.定义Map,k为元素值，v为出现频次。
        Map<Integer, Integer> map = new HashMap<>();
        //2.遍历nums,将所有元素出现频次存储在map中。
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++count);
        }
        //3.维护长度为k大小的优先级队列,顺序应该为从小到大.(当队满时，出队的是出现频率底的元素，从而确保队列里保留的都是出现频率从高到底的元素)
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        map.forEach((key, value) -> {
            // 当队列长度达到K值时，将小于当前entry.value的栈顶元素替换为当前循环的entry.value
            if (priorityQueue.size() == k) {
                if (value > priorityQueue.peek().getValue()) {
                    priorityQueue.poll();
                    offerEntry(priorityQueue, key, value);
                }
            } else {
                offerEntry(priorityQueue, key, value);
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = priorityQueue.poll().getKey();
        }
        return result;
    }

    private static void offerEntry(PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue, Integer k, Integer v) {
        priorityQueue.offer(new Map.Entry<Integer, Integer>() {
            @Override
            public Integer getKey() {
                return k;
            }

            @Override
            public Integer getValue() {
                return v;
            }

            @Override
            public Integer setValue(Integer value) {
                return null;
            }
        });
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        topKFrequent(arr, 2);
    }
}
