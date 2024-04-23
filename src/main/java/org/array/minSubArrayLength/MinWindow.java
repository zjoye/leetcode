package org.array.minSubArrayLength;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s == "" || t == "" || s.length() < t.length()) {
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
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (need[rightChar] > 0) {
                needCnt--;
            }
            need[rightChar]--;
            if (needCnt == 0) {
                char leftChar = s.charAt(left);
                while (need[leftChar] < 0) {
                    need[leftChar]++;
                    left++;
                    leftChar = s.charAt(left);
                }
                if (right - left + 1 < minSize) {
                    minSize = right - left + 1;
                    start = left;
                }
                need[s.charAt(left)]++;
                left++;
                needCnt++;
            }
            right++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minSize);

    }
}
