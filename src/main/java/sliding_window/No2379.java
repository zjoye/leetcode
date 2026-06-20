package sliding_window;

/**
 * <a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/">Leetcode Link</a>
 */
public class No2379 {

    public static int minimumRecolors(String blocks, int k) {
        int result = Integer.MAX_VALUE;
        int ops = 0;
        for (int right = 0; right < blocks.length(); right++) {
            if (blocks.charAt(right) == 'W') {
                ops++;
            }
            int left = right - k + 1;
            if (left < 0) {
                continue;
            }
            result = Math.min(ops, result);
            if (blocks.charAt(left) == 'W') {
                ops--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }
}
