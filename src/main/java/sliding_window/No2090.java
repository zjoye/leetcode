package sliding_window;

import java.util.Arrays;

public class No2090 {
    public static int[] getAverages(int[] nums, int k) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum+=nums[right];
            int left = right- 2*k;
            if(left < 0){
                continue;
            }


            result[right -k] = (int) (sum / (2*k+1));;
            sum-=nums[left];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] averages = getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3);
        for (int average : averages) {
            System.out.println(average);
        }
    }
}
