package sliding_window;

/**
 * <a href="https://leetcode.cn/problems/maximum-average-subarray-i/">Leetcode Link</a>
 */
public class No643 {

    public static double findMaxAverage(int[] nums, int k) {
        int  max = Integer.MIN_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum +=nums[right];
            int left = right - k + 1;
            if(left < 0){
                continue;
            }

            max = Math.max(max,sum);

            sum-=nums[left];

        }
        return (double) max /k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(findMaxAverage(new int[]{-1},1));
    }


}
