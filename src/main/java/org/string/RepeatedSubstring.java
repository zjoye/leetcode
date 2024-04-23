package org.string;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/repeated-substring-pattern/
 */
public class RepeatedSubstring {
    public boolean repeatedSubstringPattern(String s) {
        String tmp = s + s;
        return tmp.substring(1, tmp.length() - 1).contains(s);
    }

    public static boolean kmp(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] next = new int[len];
        Arrays.fill(next, -1);
        for (int i = 1; i < s.length(); i++) {
            int j = next[i - 1];
            while (j != -1 && arr[i] != arr[j + 1]) {
                j = next[j];
            }
            if (arr[i] == arr[j + 1]) {
                next[i] = j + 1;
            }
        }
        return next[len - 1] != -1 && len % (len - next[len - 1] - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(kmp("abab"));
    }


}
