package sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/">Leetcode Link</a>
 */
public class No2461 {

    public static long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        long sum = 0;

        Map<Integer, Long> countMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            sum +=nums[right];
            countMap.merge(nums[right],1L,Long::sum);

            int left = right - k +1;
            if (left < 0) {
                continue;
            }
            if(countMap.size() == k){
                result = Math.max(result,sum);
            }
            int out = nums[left];
            sum-=out;

            //countMap.computeIfPresent(nums[left], (kk, v) -> v > 1 ? v - 1 : null);
            Long outVal = countMap.get(out);
            if(outVal > 1){
                countMap.put(out,outVal -1);
            }
            else {
                countMap.remove(out);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1,5,4,2,9,9,9},3));
        System.out.println(maximumSubarraySum(new int[]{4,4,4},3));
        System.out.println(maximumSubarraySum(new int[]{9,9,9,1,2,3},3));

    }
}
