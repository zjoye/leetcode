package org.array.minSubArrayLength;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class MinWindow2 {

    public static String minWindow(String s, String t) {
        if (s == null || t == null | s == "" || t == "" || s.length() < t.length()) {
            return "";
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int minSize = Integer.MAX_VALUE;
        int[] need = new int[128];
        int needCnt = t.length();
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        // 不断增大窗口，直到窗口内包含t中所有元素
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            // 当前right指针的元素是需要的
            if (need[rightChar] > 0) {
                needCnt--;
            }
            need[rightChar]--;
            // needCnt==0说明s字符串在当前窗口下已经包含了所有t的字符。
            if (needCnt == 0) {
                char leftChar = s.charAt(left);
                // 移除掉所有s中多余的元素（不属于t中的元素）
                while (need[leftChar] < 0) {
                    left++;
                    need[leftChar]++;
                    leftChar = s.charAt(left);
                }
                if (right - left + 1 < minSize) {
                    minSize = right - left + 1;
                    start = left;
                }
                // 完成一次循环后，让左指针继续往后，重新寻找后续窗口内最小的元素。
                need[s.charAt(left)]++;
                left++;
                needCnt++;
            }
            right++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minSize);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
